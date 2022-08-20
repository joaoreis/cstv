package br.com.jxr.cstv.presentation.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.presentation.ui.screens.matchList.MatchItem

@ExperimentalMaterialApi
@Composable
fun ListContent(listItems: LazyPagingItems<Match>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        this.items(listItems, key = { it.id }) { match ->
            match?.let { MatchItem(match = match) }
        }

        listItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingScreen(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Error -> {
                    // TODO: Add Error View state or show snackbar
                }
            }
        }
    }
}
//
// @Composable
// @Preview
// fun PreviewListContent() {
//    val mainViewModel: MainViewModel = hiltViewModel()
//    val getMatches = mainViewModel.getMatches.collectAsLazyPagingItems()
//    LazyColumn(
//        modifier = Modifier.fillMaxSize(),
//        contentPadding = PaddingValues(12.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//
//    }
// }
