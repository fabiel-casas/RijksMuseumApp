package fabiel.casas.rijksmuseumapp.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fabiel.casas.rijksmuseumapp.R
import fabiel.casas.rijksmuseumapp.navigation.CollectionDetailFragment.Companion.ARG_OBJECT_NUMBER
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionScreen
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
class CollectionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RijksMuseumAppTheme {
                    CollectionScreen(
                        onNavDetailCollectionAction = {
                            findNavController().navigate(
                                R.id.collectionDetailFragment,
                                bundleOf(ARG_OBJECT_NUMBER to it.objectNumber)
                            )
                        }
                    )
                }
            }
        }
    }
}