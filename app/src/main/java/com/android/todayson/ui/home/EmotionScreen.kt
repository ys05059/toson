package com.android.todayson.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R
import com.android.todayson.ui.component.SignUpScaffold
import com.android.todayson.ui.component.SimpleProgressBar

@Composable
fun EmotionScreen(
    onBackClick : () -> Unit,
) {
    val name = "권세빈"
    val hoching = "할머니"
    val count = "2"
    val emotion = "우울한"
    val comment = "전문적인 상담과 치료를 권유드려요"
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        SignUpScaffold(
            buttonText = "관련 정보 보기",
            onButtonClicked = {

            },
            sheetWeight = .8f,
            headContent = {
                Text(
                    text = "오늘의 감정",
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.intro_text)
                )
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ){
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(id = R.drawable.sad_emotion),
                    contentDescription = null
                )
            }
            SimpleProgressBar(.2f)
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = """
                   $name ${hoching}는
                   현재 ${count}주 연속
                   $emotion 상태에요!
                """.trimIndent(),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 32.sp,
                lineHeight = 60.sp,
                color = colorResource(id = R.color.intro_text)
            )
            Text(
                text = comment,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 32.sp,
                lineHeight = 60.sp,
                color = colorResource(id = R.color.intro_text)
            )


        }

        ArrowBackRow(
            onBackClick = onBackClick
        )
    }

}




@Preview(showBackground = true)
@Composable
fun PrevEmotionScreen() {
    EmotionScreen({})

}