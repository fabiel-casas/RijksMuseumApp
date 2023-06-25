package fabiel.casas.rijksmuseumapp.ui.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
class CollectionDetailsViewModel(
    private val rijksMuseumUseCase: RijksMuseumUseCase
): ViewModel() {
    private val detailsState = mutableStateOf<DetailsState?>(null)
    private val isLoading = mutableStateOf(false)
    val state = CollectionDetailState(
        detailsState = detailsState,
        isLoading = isLoading,
    )
    private var objectNumber = ""

    fun loadCollectionDetail(objectNumber: String) {
        if (this.objectNumber.isNotEmpty()) return
        this.objectNumber = objectNumber
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                rijksMuseumUseCase.getCollectionDetails(objectNumber = objectNumber)
            }.onSuccess {
                detailsState.value = it
                isLoading.value = false
            }.onFailure {
                it.printStackTrace()
                isLoading.value = false
            }
        }
    }
}