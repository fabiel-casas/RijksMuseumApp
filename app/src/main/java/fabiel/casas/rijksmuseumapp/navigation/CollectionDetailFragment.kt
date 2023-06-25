package fabiel.casas.rijksmuseumapp.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fabiel.casas.rijksmuseumapp.ui.screens.details.CollectionDetailScreen
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
class CollectionDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val objectNumber = arguments?.getString(ARG_OBJECT_NUMBER).orEmpty()
        return ComposeView(requireContext()).apply {
            setContent {
                RijksMuseumAppTheme {
                    CollectionDetailScreen(
                        onBackAction = {
                            findNavController().popBackStack()
                        },
                        objectNumber = objectNumber
                    )
                }
            }
        }
    }

    companion object {
        const val ARG_OBJECT_NUMBER = "objectNumber"
    }
}