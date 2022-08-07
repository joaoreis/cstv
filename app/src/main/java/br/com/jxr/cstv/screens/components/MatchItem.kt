package br.com.jxr.cstv.screens.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.jxr.cstv.data.model.Match

@Composable
fun MatchItem(match: Match) {
    Text(text = match.name)
}

@Composable
@Preview
fun PreviewMatchItem() {
    MatchItem(
        match = Match(
            id = 1,
            name = "Team A x Team B",
            beginAt = "2022-08-07"
        )
    )
}
