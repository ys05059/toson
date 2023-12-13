package com.android.todayson

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.todayson.component.IconCard
import kotlinx.coroutines.delay


@Composable
fun IntroScreen(
    navigateToSignUp : () -> Unit = {}
) {
    LaunchedEffect(key1 = Unit){
        delay(3000)
        navigateToSignUp()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 60.dp),
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ){
            Text( text = "안녕하세요!",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(id = R.color.intro_text)
            )
            Text( text = "매일 찾아오는 ",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(id = R.color.intro_text)
            )
            Text( text = "오늘의 손녀에요",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(id = R.color.intro_text)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp),
        ){
            Spacer(modifier = Modifier.width(30.dp))
            IconCard(
                modifier = Modifier.size(180.dp),
                iconId = R.drawable.phone_call,
                colorId = R.color.phone_call
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .padding(top = 90.dp)
                    .offset(40.dp),
            ){
                IconCard(
                    modifier = Modifier.size(180.dp),
                    iconId = R.drawable.clipboard,
                    colorId = R.color.clip_board
                )
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "저와 함께 대화하고,",
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.intro_text)
            )
            Text(
                text = "감정 상태도 알아보아요.",
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.intro_text)
            )
        }
    }
}


@Preview (showBackground = true)
@Composable
fun PrevIntroScreen () {
    IntroScreen()
}