package com.android.todayson.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R

@Composable
fun SignUpStartScreen(
    navigateToNext : () -> Unit
) {
    SignUpScaffold(
        buttonText = "시작하기",
        onButtonClicked = navigateToNext,
        headContent = {
            Text(
                text = buildAnnotatedString {
                    append("간단한 ")
                    withStyle(style =  SpanStyle(fontWeight = FontWeight.Bold)){
                        append("회원가입")
                    }
                    append("을\n")
                    append("하려고 해요")

                },
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 38.sp,
                lineHeight = 60.sp,
                color = colorResource(id = R.color.intro_text)
            )
        }
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(180.dp)
                .padding( bottom = 30.dp) ,
            painter = painterResource(id = R.drawable.sound),
            contentDescription = null
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style =  SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.signup_sound_text)
                )){
                    append("확성기 아이콘")
                }
                append("을\n누르시면 ")
                withStyle(style =  SpanStyle(fontWeight = FontWeight.Bold)){
                    append("음성안내")
                }
                append("를\n들으실 수 있어요")

            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 38.sp,
            lineHeight = 60.sp,
            color = colorResource(id = R.color.intro_text)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun PrevStartScreen() {
    SignUpStartScreen(
        {}
    )

}