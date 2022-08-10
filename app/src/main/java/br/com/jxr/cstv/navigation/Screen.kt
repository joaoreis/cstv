package br.com.jxr.cstv.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Details : Screen("details_screen")
}
