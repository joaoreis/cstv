package br.com.jxr.cstv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.jxr.cstv.navigation.SetupNavGraph
import br.com.jxr.cstv.ui.theme.CstvTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CstvTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}
