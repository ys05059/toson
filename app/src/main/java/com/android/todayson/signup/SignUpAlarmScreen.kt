package com.android.todayson.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.todayson.R
import com.android.todayson.component.SignUpScaffold
import com.android.todayson.component.TimePickerDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpAlarmScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateToNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val state = rememberTimePickerState()
    var morning by remember { mutableStateOf(uiState.alarm.morning) }
    var noon by remember { mutableStateOf(uiState.alarm.noon) }
    var evening by remember { mutableStateOf(uiState.alarm.evening) }

    var openDialog by remember { mutableStateOf(0) }

    if (openDialog > 0) {
        TimePickerDialog(
            title = "시간을 선택하세요",
            onCancel = {
                openDialog = 0
            },
            onConfirm = {
                when(openDialog){
                    1 -> morning = Pair(state.hour,state.minute)
                    2 -> noon = Pair(state.hour,state.minute)
                    3 -> evening = Pair(state.hour,state.minute)
                }
                openDialog = 0

            }
        ) {
            TimePicker(state = state)
        }
    }

    SignUpScaffold(
        onButtonClicked = {
            viewModel.updateAlarm(
                Alarm(morning,noon,evening)
            )
            navigateToNext()
        },
        headContent = {
            SignUpIntroText(4)
        }
    ) {
        Text(
            text = buildAnnotatedString {
                append("저는 하루에 3번 찾아올게요,\n")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("몇시")
                }
                append("에 볼까요?")
            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 27.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.intro_text)
        )
        TimeSettingRow(
            category = "아침",
            hour = morning.first.toString(),
            minute = morning.second.toString(),
            onTimeClick = {
                openDialog = 1
            }
        )
        TimeSettingRow(
            category = "점심",
            hour = noon.first.toString(),
            minute = noon.second.toString(),
            onTimeClick = {
                openDialog = 2
            }
        )
        TimeSettingRow(
            category = "저녁",
            hour = evening.first.toString(),
            minute = evening.second.toString(),
            onTimeClick = {
                openDialog = 3
            }

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeSettingRow(
    category: String,
    hour: String,
    minute : String,
    onTimeClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = category,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            color = colorResource(id = R.color.intro_text)
        )

        Surface(
            modifier = Modifier
                .padding(start = 16.dp)
                .width(60.dp),
            shape = RoundedCornerShape(12.dp),
            color = colorResource(id = R.color.signup_round_text_background),
            onClick = onTimeClick
        ) {
            Text(
                text = hour,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.intro_text)

            )
        }

        Text(
            modifier = Modifier,
            text = "시",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 28.sp,
            lineHeight = 40.sp,
            color = colorResource(id = R.color.intro_text)
        )

        Surface(
            modifier = Modifier
                .padding(start = 16.dp)
                .width(60.dp),
            shape = RoundedCornerShape(12.dp),
            color = colorResource(id = R.color.signup_round_text_background),
            onClick = onTimeClick
        ) {
            Text(
                text = minute,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.intro_text)

            )
        }

        Text(
            text = "분",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 28.sp,
            lineHeight = 40.sp,
            color = colorResource(id = R.color.intro_text)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    SignUpAlarmScreen {

    }

}