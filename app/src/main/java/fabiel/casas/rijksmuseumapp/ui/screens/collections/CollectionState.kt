package fabiel.casas.rijksmuseumapp.ui.screens.collections

import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.Serializable

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
data class CollectionState(
    val collection: StateFlow<PagingData<CollectionItemState>> = MutableStateFlow(
        PagingData.empty()
    ),
)

data class CollectionItemState(
    val objectNumber: String,
    val collectionTitle: String,
    val description: String,
    val imageUrl: String,
    val webImageUrl: String,
): Serializable
