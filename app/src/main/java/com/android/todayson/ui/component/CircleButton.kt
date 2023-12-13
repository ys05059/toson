package com.android.todayson.ui.component

import androidx.annotation.ColorRes
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircleButton(
    modifier : Modifier = Modifier,
    enabled : Boolean = true,
    basicBackgroundColor : Color,
    pressedBackgroundColor : Color = basicBackgroundColor,
    onClick : () -> Unit = {},
    content : @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = basicBackgroundColor,
        contentColor = basicBackgroundColor,
        onClick = onClick
    ){
        Box(
            contentAlignment = Alignment.Center
        ){
            content()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PrevCircleBtn() {
    CircleButton(
        modifier = Modifier.size(40.dp),
        basicBackgroundColor = Color.Red,
    ){
        Text(
            "남자",
            color = Color.White
        )
    }
}