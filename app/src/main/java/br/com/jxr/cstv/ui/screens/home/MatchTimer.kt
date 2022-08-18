package br.com.jxr.cstv.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jxr.cstv.ui.theme.Red

@Composable
fun MatchTimer(startDate: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 16.dp,
            bottomEnd = 0.dp
        ),
        color = backgroundColor
    ) {
        Text(
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            text = startDate,
            modifier = modifier.padding(horizontal = 7.dp, vertical = 6.dp)
//                .background(backgroundColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMatchTimer() {
    MatchTimer(startDate = "17/08/2022", backgroundColor = Red)
}
