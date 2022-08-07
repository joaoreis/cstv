package br.com.jxr.cstv.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
}
