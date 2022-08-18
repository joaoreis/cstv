package br.com.jxr.cstv.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.jxr.cstv.ui.screens.components.ListContent
import br.com.jxr.cstv.ui.theme.DarkPurple

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    mainViewModel: HomeViewModel = hiltViewModel()
) {
    val getMatches = mainViewModel.getMatches.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { DefaultAppbar() },
        content = {
            ListContent(listItems = getMatches)
        }
    )
}

@Composable
fun DefaultAppbar() =
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        backgroundColor = DarkPurple,
        title = {
            Text(
                text = "Partidas",
                fontSize = 40.sp,
                modifier = Modifier.padding(15.dp)
            )
        }
    )
