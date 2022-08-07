package br.com.jxr.cstv.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import br.com.jxr.cstv.data.model.Match
import br.com.jxr.cstv.ui.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val getMatches = mainViewModel.getMatches.collectAsLazyPagingItems()

    Scaffold(
        content = {
            ListContent(listItems = getMatches)
        }
    )
}

@Composable
fun ListContent(listItems: LazyPagingItems<Match>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        this.items(listItems, key = { it.id }) { match ->
            match?.let { MatchItem(match = match) }
        }
    }
}

@Composable
fun MatchItem(match: Match) {
    Text(text = match.name)
}

@Preview
@Composable
fun Preview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}
