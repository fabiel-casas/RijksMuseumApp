package fabiel.casas.rijksmuseumapp.usecase

import androidx.paging.PagingData
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionItemState
import fabiel.casas.rijksmuseumapp.ui.screens.details.DetailsState
import kotlinx.coroutines.flow.Flow

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
interface RijksMuseumUseCase {
    fun collectionPaginated(): Flow<PagingData<CollectionItemState>>
    suspend fun getCollectionDetails(objectNumber: String): DetailsState
}