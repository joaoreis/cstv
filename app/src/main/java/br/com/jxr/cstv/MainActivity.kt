@file:OptIn(ExperimentalMaterialApi::class)

package br.com.jxr.cstv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.jxr.cstv.ui.theme.CstvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CstvTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MatchesHeader() {
    Text(text = "Partidas")
}

@Composable
fun MainScreen() {
    MatchesHeader()
    MatchesList()
}

@Composable
fun MatchesList() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        MatchCard()
        MatchCard()
    }
//    MatchCard()
}

@Composable
fun MatchCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.primary,
        onClick = { /*TODO*/ },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                TeamLogo()
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp),
                    text = "VS"
                )
                TeamLogo()
            }
            Row {
                Divider(
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun TeamLogo() {
    Column {
        Surface(
            color = MaterialTheme.colors.secondary,
            shape = CircleShape,
            modifier = Modifier
                .padding(10.dp)
                .size(75.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            // image here
        }
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            text = "Team Name"
        )
    }
}
/*
* Card(
shape = RoundedCornerShape(8.dp),
backgroundColor = MaterialTheme.colors.surface,
) {
Column(
    modifier = Modifier.height(200.dp).padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
){
    Text(text = "This is a card view",
        style = MaterialTheme.typography.h4)
}
}
* */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CstvTheme {
//        MainScreen()
        MatchCard()
    }
}
