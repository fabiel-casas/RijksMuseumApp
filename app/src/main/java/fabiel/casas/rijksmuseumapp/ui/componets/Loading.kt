package fabiel.casas.rijksmuseumapp.ui.componets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
@Composable
fun LoadingContent() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = MaterialTheme.colorScheme.primary,
    )
}