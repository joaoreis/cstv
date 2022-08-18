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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jxr.cstv.domain.model.*
import br.com.jxr.cstv.ui.screens.components.LogoImage
import br.com.jxr.cstv.ui.screens.components.TeamLogo
import br.com.jxr.cstv.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun MatchItem(match: Match, modifier: Modifier = Modifier) {
    Card(
        shape = Shapes.large,
        backgroundColor = LightPurple,
        modifier = modifier.padding(15.dp),
        onClick = {}
    ) {
        Column(
            content = {
                Box(
                    modifier = modifier
                        .align(Alignment.End)
                ) {
                    val backgroundColor =
                        if (match.status == MatchStatus.RUNNING) Red else LightGray
                    MatchTimer(match.beginAt, backgroundColor, modifier)
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    MatchTeams(match = match)
                }

                MatchFooter(Modifier, match.league, match.serie)
            }

        )
    }
}

@Composable
private fun MatchTeams(modifier: Modifier = Modifier, match: Match) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(10.dp)
    ) {
        match.teams.firstOrNull()?.let { TeamLogo(team = it) }
        Text(
            text = "vs",
            color = LighterGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        TeamLogo(team = match.teams[1])
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
