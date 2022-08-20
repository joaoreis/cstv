package br.com.jxr.cstv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.jxr.cstv.presentation.ui.screens.matchList.NavGraphs
import br.com.jxr.cstv.presentation.ui.theme.CstvTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CstvTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
