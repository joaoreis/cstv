package br.com.jxr.cstv.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.jxr.cstv.screens.components.ListContent
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

@Preview
@Composable
fun Preview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}
