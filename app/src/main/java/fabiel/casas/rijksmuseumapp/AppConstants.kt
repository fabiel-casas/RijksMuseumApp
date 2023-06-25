package fabiel.casas.rijksmuseumapp

import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionState
import fabiel.casas.rijksmuseumapp.ui.screens.details.CollectionDetailState

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */
object AppConstants {
    const val COLLECTION_PAGE_SIZE = 100
    const val COLLECTION_SORT_BY = "artist"

    val collectionStateSample = CollectionState()
    val collectionDetailState = CollectionDetailState()
}