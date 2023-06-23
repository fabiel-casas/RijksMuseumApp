package fabiel.casas.rijksmuseumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fabiel.casas.rijksmuseumapp.ui.screens.collections.CollectionScreen
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RijksMuseumAppTheme {
                // A surface container using the 'background' color from the theme
                CollectionScreen(
                    onNavDetailCollectionAction = {}
                )
            }
        }
    }
}
