package br.com.jxr.cstv.ui.screens

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.jxr.cstv.ui.screens.components.ListContent

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: HomeViewModel = hiltViewModel()
) {
    val getMatches = mainViewModel.getMatches.collectAsLazyPagingItems()
    Log.d("tag", "${getMatches.itemCount}")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "CS:TV") }
            )
        },
        content = {
            ListContent(listItems = getMatches)
        }
    )
}

@Preview
@Composable
fun Previe() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}
