package fabiel.casas.rijksmuseumapp.ui.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.io.Serializable

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
data class CollectionDetailState(
    val detailsState: State<DetailsState?> = mutableStateOf(null),
    val isLoading: State<Boolean> = mutableStateOf(false),
)

data class DetailsState(
    val objectNumber: String,
    val title: String,
    val imageUrl: String,
    val authors: List<String>,
    val subTitle: String,
    val description: String,
    val presentingDate: String,
    val period: String,
): Serializable
