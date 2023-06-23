package fabiel.casas.rijksmuseumapp.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import fabiel.casas.rijksmuseumapp.AppConstants
import fabiel.casas.rijksmuseumapp.data.datasource.RijksMuseumDataSource
import fabiel.casas.rijksmuseumapp.data.networking.response.ArtObject
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionItemState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
class RijksMuseumUseCaseImpl(
    private val pagingSource: PagingSource<Int, ArtObject>,
    private val dataSource: RijksMuseumDataSource,
): RijksMuseumUseCase {
    override fun collectionPaginated(): Flow<PagingData<CollectionItemState>> {
        return Pager(PagingConfig(AppConstants.COLLECTION_PAGE_SIZE)) {
            pagingSource
        }.flow.map { data ->
            data.map {
                it.toCollectionItem()
            }
        }
    }

    private fun ArtObject.toCollectionItem() = CollectionItemState(
        objectNumber = objectNumber,
        collectionTitle = title,
        description = longTitle,
        imageUrl = headerImage.url,
        webImageUrl = webImage.url,
    )
}