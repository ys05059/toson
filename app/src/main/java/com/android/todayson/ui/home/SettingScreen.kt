package com.android.todayson.ui.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R
import com.android.todayson.ui.component.IconCard

@Composable
fun SettingScreen(
    onBackClick : () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        ArrowBackRow(
            onBackClick = onBackClick
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text = "환경 설정",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.intro_text)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    IconCard(
                        modifier = Modifier
                            .size(160.dp),
                        enabled = true,
                        iconId = R.drawable.change_name,
                        colorId = R.color.phone_call
                    )
                    Text(
                        text = "이름 변경",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        lineHeight = 60.sp,
                        color = colorResource(id = R.color.intro_text)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconCard(
                        modifier = Modifier
                            .size(160.dp),
                        enabled = true,
                        iconId = R.drawable.change_sex,
                        colorId = R.color.yellow
                    )
                    Text(
                        text = "성별 변경",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        lineHeight = 60.sp,
                        color = colorResource(id = R.color.intro_text)
                    )
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    IconCard(
                        modifier = Modifier
                            .size(160.dp),
                        enabled = true,
                        iconId = R.drawable.change_date,
                        colorId = R.color.clip_board
                    )
                    Text(
                        text = "생일 변경",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        lineHeight = 60.sp,
                        color = colorResource(id = R.color.intro_text)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconCard(
                        modifier = Modifier
                            .size(160.dp),
                        enabled = true,
                        iconId = R.drawable.change_time,
                        colorId = R.color.signup_bottom_button
                    )
                    Text(
                        text = "시간 변경",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        lineHeight = 60.sp,
                        color = colorResource(id = R.color.intro_text)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevSettingScreen() {
    SettingScreen {

    }
}