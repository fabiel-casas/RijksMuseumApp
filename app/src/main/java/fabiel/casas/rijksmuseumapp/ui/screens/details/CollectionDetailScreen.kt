package fabiel.casas.rijksmuseumapp.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import fabiel.casas.rijksmuseumapp.AppConstants.collectionDetailState
import fabiel.casas.rijksmuseumapp.R
import fabiel.casas.rijksmuseumapp.ui.componets.LoadingContent
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme
import org.koin.androidx.compose.getViewModel

/**
 * RijksMuseumApp
 * Created on 25/06/2023.
 * Author: johan
 */
@Composable
fun CollectionDetailScreen(
    onBackAction: () -> Unit,
    objectNumber: String,
    viewModel: CollectionDetailsViewModel = getViewModel(),
) {
    LaunchedEffect(key1 = objectNumber, viewModel, block = {
        viewModel.loadCollectionDetail(objectNumber)
    })
    val state = viewModel.state
    if (state.isLoading.value) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        CollectionDetailContent(
            state = state,
            onBackAction = onBackAction
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CollectionDetailContent(
    state: CollectionDetailState,
    onBackAction: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackAction) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = state.detailsState.value?.title.orEmpty(),
                        maxLines = 1,
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
        bottomBar = {
            BottomChips(
                chipsItems = state.detailsState.value?.authors.orEmpty()
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(state = rememberScrollState())
        ) {
            if (!state.detailsState.value?.imageUrl.isNullOrEmpty()) {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(100.dp, 500.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(state.detailsState.value?.imageUrl)
                        .crossfade(true)
                        .scale(Scale.FIT)
                        .build(),
                    loading = {
                        LoadingContent()
                    },
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
            val paddingModifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
            Text(
                modifier = paddingModifier,
                text = state.detailsState.value?.subTitle.orEmpty(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
            if (!state.detailsState.value?.description.isNullOrEmpty()) {
                Text(
                    modifier = paddingModifier,
                    text = state.detailsState.value?.description.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
            Text(
                modifier = paddingModifier,
                text = stringResource(R.string.period, state.detailsState.value?.period.orEmpty()),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                modifier = paddingModifier,
                text = stringResource(
                    R.string.presenting_date,
                    state.detailsState.value?.presentingDate.orEmpty()
                ),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomChips(chipsItems: List<String>) {
    Surface {
        LazyRow(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            content = {
                items(chipsItems) {
                    Spacer(modifier = Modifier.width(16.dp))
                    AssistChip(
                        onClick = {},
                        label = {
                            Text(
                                text = it,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        },
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CollectionDetailContentPreview() {
    RijksMuseumAppTheme {
        CollectionDetailContent(
            state = remember {
                collectionDetailState
            },
            onBackAction = {}
        )
    }
}