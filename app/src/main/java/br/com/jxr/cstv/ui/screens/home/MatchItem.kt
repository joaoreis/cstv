package br.com.jxr.cstv.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jxr.cstv.domain.model.*
import br.com.jxr.cstv.ui.screens.components.LogoImage
import br.com.jxr.cstv.ui.screens.components.TeamLogo
import br.com.jxr.cstv.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun MatchItem(match: Match) {
    Card(
        shape = Shapes.large,
        backgroundColor = LightPurple,
        modifier = Modifier.padding(15.dp),
        onClick = {}
    ) {
        Column(
            content = {
                Box(modifier = Modifier.align(Alignment.End)) {
                    MatchTimer(match.beginAt, match.status)
                }
                MatchTeams(match)
                MatchFooter(Modifier, match.league, match.serie)
            }
        )
    }
}

@Composable
fun MatchTimer(startDate: String, status: MatchStatus) {
    Card(
        shape = Shapes.large,
        backgroundColor = if (status == MatchStatus.RUNNING) Red else LightGray,
        modifier = Modifier
            .clipToBounds()
            .offset(x = 30.dp, y = (-30).dp)
    ) {
        Text(
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            text = startDate,
            modifier = Modifier
                .padding(22.dp)
                .offset(x = (-13).dp, y = 15.dp)
        )
    }
}

@Composable
private fun MatchTeams(match: Match) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            match.teams?.firstOrNull()?.let { TeamLogo(team = it) }
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(35.dp),
                text = "VS",
                color = LighterGray
            )
            match.teams?.firstOrNull()?.let { TeamLogo(team = it) }
        }
    }
}

@Composable
fun MatchFooter(
    modifier: Modifier = Modifier,
    league: League,
    serie: Serie
) {
    Divider(
        color = LighterGray,
        modifier = modifier
            .fillMaxWidth()
            .clipToBounds()
    )
    Row(
        modifier = modifier.padding(15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogoImage(league.imageUrl, Modifier.size(20.dp))
        Text(
            text = "${league.name} - ${serie.fullName}",
            color = Color.White,
            fontSize = 11.sp,
            modifier = modifier.padding(start = 15.dp)
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun PreviewMatchItem() {
    val match = Match(
        123,
        "a Match",
        listOf(
            Team(1, "Team A", ""),
            Team(2, "Team B", "")
        ),
        League("league", ""),
        Serie("Serie"),
        MatchStatus.NOT_STARTED,
        "10/09/2022"
    )
    MatchItem(match = match)
}
