package fabiel.casas.rijksmuseumapp.ui.screens.collections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import fabiel.casas.rijksmuseumapp.usecase.RijksMuseumUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
class CollectionViewModel(
    private val rijksMuseumUseCase: RijksMuseumUseCase,
) : ViewModel() {
    private val collection = MutableStateFlow<PagingData<CollectionItemState>>(PagingData.empty())
    val state = CollectionState(
        collection = collection.asStateFlow()
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            rijksMuseumUseCase.collectionPaginated()
                .flowOn(Dispatchers.IO)
                .cachedIn(viewModelScope)
                .catch {
                    it.printStackTrace()
                }
                .collectLatest {
                    collection.value = it
                }
        }
    }
}