package fabiel.casas.rijksmuseumapp.ui.screens.collections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import fabiel.casas.rijksmuseumapp.AppConstants.collectionStateSample
import fabiel.casas.rijksmuseumapp.R
import fabiel.casas.rijksmuseumapp.ui.theme.RijksMuseumAppTheme
import org.koin.androidx.compose.getViewModel

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */

@Composable
fun CollectionScreen(
    viewModel: CollectionViewModel = getViewModel(),
    onNavDetailCollectionAction: (CollectionItemState) -> Unit,
) {
    CollectionContent(
        state = viewModel.state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CollectionContent(
    state: CollectionState
) {
    val collectionItems = state.collection.collectAsLazyPagingItems()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.collection_title),
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            content = {
                if (collectionItems.loadState.refresh == LoadState.Loading) {
                    item {
                        Text(
                            text = stringResource(R.string.waiting_for_items),
                            modifier = Modifier.fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }
                items(
                    count = collectionItems.itemCount,
                    key = collectionItems.itemKey { it },
                    contentType = collectionItems.itemContentType { "CollectionPagingItems" }
                ) { index ->
                    collectionItems[index]?.let {
                        CollectionItem(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .fillMaxWidth(),
                            state = it
                        )
                    }
                }
                if (collectionItems.loadState.append == LoadState.Loading) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally),
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun CollectionItem(
    modifier: Modifier,
    state: CollectionItemState
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth()
                .heightIn(100.dp, 400.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(state.webImageUrl)
                .crossfade(true)
                .scale(Scale.FIT)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            text = state.collectionTitle,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = state.description,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CollectionContentPreview() {
    RijksMuseumAppTheme {
        CollectionContent(
            state = collectionStateSample
        )
    }
}