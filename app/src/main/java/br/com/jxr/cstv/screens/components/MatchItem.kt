@file:OptIn(ExperimentalMaterialApi::class)

package br.com.jxr.cstv.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.jxr.cstv.data.model.dto.MatchDto
import br.com.jxr.cstv.ui.theme.LightPurple
import br.com.jxr.cstv.ui.theme.LighterGray

@Composable
fun MatchItem(match: MatchDto) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = LightPurple,
        onClick = {}
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                match.opponents[0].opponent?.let { TeamLogo(it) }
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(35.dp),
                    text = "VS",
                    color = LighterGray
                )
                match.opponents[0].opponent?.let { TeamLogo(it) }
            }
        }
    }
}
