package fabiel.casas.rijksmuseumapp.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import fabiel.casas.rijksmuseumapp.AppConstants.COLLECTION_PAGE_SIZE
import fabiel.casas.rijksmuseumapp.BuildConfig
import fabiel.casas.rijksmuseumapp.data.networking.RijksMuseumApi
import fabiel.casas.rijksmuseumapp.data.networking.response.ArtObject
import fabiel.casas.rijksmuseumapp.getCulture

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
class RijksCollectionPagingSource(
    private val rijksMuseumApi: RijksMuseumApi
) : PagingSource<Int, ArtObject>() {

    override fun getRefreshKey(state: PagingState<Int, ArtObject>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArtObject> {
        val page = params.key ?: 0
        val result = runCatching {
            rijksMuseumApi.getCollection(
                culture = getCulture(),
                key = BuildConfig.MUSEUM_API_KEY, // Configure this constant in the local.properties
                page = page,
                pageSize = COLLECTION_PAGE_SIZE
            )
        }
        return if (result.isSuccess) {
            val resultList = result.getOrNull()?.artObjects ?: emptyList()
            LoadResult.Page(
                data = resultList,
                prevKey = if (page < 1) null else page - 1,
                nextKey = if (resultList.isEmpty()) null else page + 1
            )
        } else {
            LoadResult.Error(result.exceptionOrNull() ?: Exception())
        }
    }
}