package br.com.jxr.cstv.presentation.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.jxr.cstv.R
import br.com.jxr.cstv.domain.model.Team
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun TeamLogo(team: Team, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        LogoImage(
            url = team.imageUrl,
            modifier = modifier.size(75.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = modifier,
            text = team.name,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun LogoImage(url: String?, modifier: Modifier = Modifier) {
    val imageData = if (url.isNullOrEmpty()) R.drawable.cs_logo else url
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageData)
            .placeholder(R.drawable.cs_logo)
            .error(R.drawable.cs_logo)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_image_placeholder),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun previewTeamLogo() {
//    val logoUrl =
//        "https://s2.glbimg.com/9hLtG2DbMA9l11iMODEnBHv94iU=/0x0:1200x603/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2019/i/b/ETfVe9TSWL7BL6NLQZYQ/1535723475188-fb-image.png"
    val team = Team(1, "very big team name example \n another line", "")
    TeamLogo(team)
}
