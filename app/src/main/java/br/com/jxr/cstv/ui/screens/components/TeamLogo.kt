package br.com.jxr.cstv.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.jxr.cstv.R
import br.com.jxr.cstv.domain.model.Team
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun TeamLogo(team: Team) {
    Column {
        LogoImage(
            url = team.imageUrl,
            modifier = Modifier.size(75.dp)
        )
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            text = team.name,
            color = Color.White
        )
    }
}

@Composable
fun LogoImage(url: String?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_image_placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true)
fun previewTeamLogo() {
    val logoUrl =
        "https://static.wikia.nocookie.net/mobile-legends/" +
            "images/3/3a/NAVI-RU_logo.png/revision/latest?cb=20211208091612"
    TeamLogo(Team(1, "Navi", logoUrl))
}
