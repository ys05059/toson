package com.android.todayson.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallScreen(
    onCallClick : () -> Unit,
    onCloseClick: () -> Unit
) {
    QuestionScaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    onClick = onCloseClick,
                    shape = CircleShape,
                    modifier = Modifier.size(72.dp),
                    color = Color.Transparent
                ){
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text  = "오후 12:15",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 56.sp,
                    lineHeight = 60.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text  = "10월 26일 수요일",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 32.sp,
                    lineHeight = 60.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text  = "오늘의 손녀가\n찾아왔어요 !",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 38.sp,
                    lineHeight = 60.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ){

                Surface(
                    modifier = Modifier
                        .size(160.dp),
                    onClick = onCallClick,
                    shape = CircleShape,
                    color = colorResource(id = R.color.call_background)
                ){
                    Image(
                        modifier = Modifier.fillMaxSize().padding(40.dp),
                        painter = painterResource(id = R.drawable.phone_call),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevCallScreen() {
    CallScreen(
        {}
    ) {

    }
}