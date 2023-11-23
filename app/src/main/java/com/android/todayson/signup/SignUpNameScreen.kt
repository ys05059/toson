package com.android.todayson.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.android.todayson.component.CircleButton

@Composable
fun SignUpNameScreen(
    navigateToNext : () -> Unit
) {
    SignUpScaffold(
        onButtonClicked = navigateToNext,
        headContent = {
            SignUpIntroText()
        }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style =  SpanStyle(
                    fontWeight = FontWeight.Bold,
                )
                ){
                    append("성함")
                }
                append("을 말씀해주세요 ")
            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            lineHeight = 60.sp,
            color = colorResource(id = R.color.intro_text)
        )
        CircleButton(
            modifier = Modifier.size(180.dp),
            basicBackgroundColor = colorResource(id = R.color.signup_say_button)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp) ,
                painter = painterResource(id = R.drawable.microphone),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = buildAnnotatedString {
                    withStyle(style =  SpanStyle(
                        fontWeight = FontWeight.Bold,
                    )
                    ){
                        append("성함 :  ")
                    }
                },
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                color = colorResource(id = R.color.intro_text)
            )

            Surface(
                modifier = Modifier.padding(horizontal = 16.dp),
                shape = RoundedCornerShape(12.dp),
                color = colorResource(id = R.color.signup_round_text_background)
            ){
                Text(
                    text = "권세빈",
                    modifier = Modifier.padding(horizontal = 32.dp),
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 36.sp,
                    color = colorResource(id = R.color.intro_text)

                )
            }



        }
    }
}


@Composable
fun SignUpIntroText(
    step : Int = 1
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "회원가입",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 52.sp,
            color = colorResource(id = R.color.intro_text)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "${step}단계",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.intro_text)
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(52.dp)
                    .padding(start = 16.dp)
                ,
                painter = painterResource(id = R.drawable.sound),
                alignment = Alignment.CenterStart,
                contentDescription = null
            )
        }

    }
    
}

@Preview(showBackground = true)
@Composable
fun PrevNameScreen() {
    SignUpNameScreen(
        {}
    )

}