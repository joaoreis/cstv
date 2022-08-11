package br.com.jxr.cstv.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.jxr.cstv.ui.screens.details.DetailsScreen
import br.com.jxr.cstv.ui.screens.home.HomeScreen

@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Details.route) {
            DetailsScreen(navController = navController)
        }
    }
}
