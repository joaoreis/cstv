package br.com.jxr.cstv.presentation.ui.screens.matchList

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
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.jxr.cstv.presentation.ui.screens.components.ListContent
import br.com.jxr.cstv.presentation.ui.theme.DarkPurple
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination(start = true)
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    mainViewModel: MatchListViewModel = hiltViewModel()
) {
    val matches = mainViewModel.matches.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { DefaultAppbar() },
        content = {
            ListContent(listItems = matches)
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
