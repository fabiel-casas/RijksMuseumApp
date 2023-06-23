package fabiel.casas.rijksmuseumapp.usecase

import androidx.paging.PagingData
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionItemState
import kotlinx.coroutines.flow.Flow

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
interface RijksMuseumUseCase {
    fun collectionPaginated(): Flow<PagingData<CollectionItemState>>
}