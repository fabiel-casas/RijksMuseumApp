package fabiel.casas.rijksmuseumapp

import androidx.paging.PagingData
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionItemState
import fabiel.casas.rijksmuseumapp.ui.screens.details.DetailsState
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * RijksMuseumApp
 * Created on 26/06/2023.
 * Author: johan
 */
class RijksMuseumUseCaseFake: RijksMuseumUseCase {
    override fun collectionPaginated(): Flow<PagingData<CollectionItemState>> {
        return flow {
            emit(PagingData.from(listOf(AppConstants.collectionItemState)))
        }
    }

    override suspend fun getCollectionDetails(objectNumber: String): DetailsState {
        return AppConstants.detailsState
    }
}