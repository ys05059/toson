package com.android.todayson.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R
import com.android.todayson.component.IconCard

@Composable
fun HomeScreen(
    navigateToQuestion : () -> Unit,
    navigateToEmotion : () -> Unit,
    navigateToSetting : () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val sex = "여"
        val hoching = if(sex == "남")"할아버지" else "할머니"
        Text(
            text = buildAnnotatedString {
                append("어서오세요,\n")
                withStyle(style =  SpanStyle(fontWeight = FontWeight.Bold)){
                    append("권세빈")
                }
                append(" $hoching!")

            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.intro_text)
        )
        IconCard(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(220.dp)
                .height(160.dp)
            ,
            text = "오늘의 질문",
            enabled = true,
            iconId = R.drawable.phone_call,
            colorId = R.color.phone_call,
            onClick = navigateToQuestion
        )
        IconCard(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(220.dp)
                .height(160.dp)
            ,
            text = "오늘의 감정",
            enabled = true,
            iconId = R.drawable.clipboard,
            colorId = R.color.clip_board,
            onClick = navigateToEmotion
        )
        IconCard(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(220.dp)
                .height(160.dp)
            ,
            text = "환경설정",
            enabled = true,
            iconId = R.drawable.settings,
            colorId = R.color.yellow,
            onClick = navigateToSetting
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PrevHomeScreen() {
    HomeScreen(
        {},{},{}
    )

}