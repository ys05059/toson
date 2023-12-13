package com.android.todayson.ui.component

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R


@Composable
fun IconCard(
    modifier: Modifier = Modifier,
    text: String = "",
    enabled: Boolean = false,
    @DrawableRes iconId: Int,
    @ColorRes colorId: Int,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = if (enabled) LocalIndication.current else null,
            ),
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = colorId)
        )
    ) {
        Column(
            modifier = Modifier.padding(
                if (text.isNotEmpty()) 24.dp else 40.dp
            )
        ) {
            Image(
                modifier = if (text.isNotEmpty()) Modifier
                    .weight(1f)
                    .fillMaxWidth() else Modifier.fillMaxSize(),
                painter = painterResource(id = iconId),
                contentDescription = null
            )
            if (text.isNotEmpty()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = text,
                    color = Color.White,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }

    }
}

@Preview
@Composable
fun PrevIconCard() {
    IconCard(
        modifier = Modifier.width(180.dp).height(160.dp),
        iconId = R.drawable.phone_call,
        colorId = R.color.phone_call,
        text = "오늘의 질문",
        onClick = {}
    )

}