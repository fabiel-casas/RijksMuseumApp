package fabiel.casas.rijksmuseumapp.ui.screens.collections

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import fabiel.casas.rijksmuseumapp.AppConstants.collectionStateSample
import fabiel.casas.rijksmuseumapp.R
import fabiel.casas.rijksmuseumapp.ui.componets.LoadingContent
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
        state = viewModel.state,
        onNavDetailCollectionAction = onNavDetailCollectionAction
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun CollectionContent(
    state: CollectionState,
    onNavDetailCollectionAction: (CollectionItemState) -> Unit,
) {
    val lazyPagingItems = state.collection.collectAsLazyPagingItems()
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
                val derivedGroup = derivedStateOf {
                    lazyPagingItems.groupBy { it.author }
                }
                if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
                    item {
                        Column {
                            Text(
                                text = stringResource(R.string.waiting_for_items),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            LoadingContent()
                        }
                    }
                }
                derivedGroup.value.keys.toList()
                    .forEach { header ->
                        stickyHeader {
                            Surface(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp, vertical = 8.dp)
                                        .fillMaxWidth(),
                                    text = header,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                )
                            }
                        }
                        items(derivedGroup.value[header] ?: emptyList(), key = { it.objectNumber }) { collectionItem ->
                            CollectionItem(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    .clickable { onNavDetailCollectionAction(collectionItem) }
                                    .fillMaxWidth(),
                                state = collectionItem
                            )
                            //This update the pager status to be able to load the next page.
                            lazyPagingItems.findIndex { it.objectNumber == collectionItem.objectNumber }
                                ?.let {
                                    lazyPagingItems[it]
                                }
                        }
                    }
                if (lazyPagingItems.loadState.append == LoadState.Loading) {
                    item {
                        LoadingContent()
                    }
                }
            }
        )
    }
}

private inline fun <T : Any> LazyPagingItems<T>.findIndex(keySelector: (T) -> Boolean): Int? {
    for (index in 0 until itemCount) {
        peek(index)?.let { element ->
            if (keySelector(element)) {
                return index
            }
        }
    }
    return null
}

private inline fun <T : Any, K> LazyPagingItems<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
    val map = LinkedHashMap<K, MutableList<T>>()
    for (index in 0 until itemCount) {
        peek(index)?.let { element ->
            val key = keySelector(element)
            val list = map.getOrPut(key) { ArrayList<T>() }
            list.add(element)
        }
    }
    return map
}

@Composable
fun CollectionItem(
    modifier: Modifier,
    state: CollectionItemState
) {
    Column(
        modifier = modifier
    ) {
        if (state.webImageUrl.isNotEmpty()) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(100.dp, 400.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.webImageUrl)
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
            state = collectionStateSample,
            onNavDetailCollectionAction = {}
        )
    }
}