package com.android.todayson.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.todayson.R
import com.android.todayson.component.RoundedButton
import com.android.todayson.component.SignUpScaffold
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpBirthScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateToNext : () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    DatePicker(state = datePickerState)
    val selectedDate = datePickerState.selectedDateMillis?.let {
        Instant.ofEpochMilli(it).atOffset(ZoneOffset.UTC)
    } ?: OffsetDateTime.now(ZoneOffset.UTC)

    var openDialog by remember { mutableStateOf(false) }
    if(openDialog){
        DatePickerDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text("완료")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text("취소")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
            )
        }
    }

    SignUpScaffold(
        onButtonClicked = {
            viewModel.updateBirth(
                Birth(
                    year = selectedDate.year,
                    month = selectedDate.monthValue,
                    day = selectedDate.dayOfMonth
                )
            )
            navigateToNext()
        },
        headContent = {
            SignUpIntroText(3)
        }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style =  SpanStyle(
                    fontWeight = FontWeight.Bold,
                )
                ){
                    append("생년월일")
                }
                append("을 알려주세요")
            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            lineHeight = 60.sp,
            color = colorResource(id = R.color.intro_text)
        )

        RoundedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 16.dp)
            ,
            basicBackgroundColor = colorResource(id = R.color.signup_round_text_background),
            pressedBackgroundColor = colorResource(id = R.color.signup_round_text_background),
            roundedCornerSize = 15.dp,
            onClick = {
                openDialog = true
            }
        ) {
            Text(
                text = "${selectedDate.year}년 ${selectedDate.monthValue}월 ${selectedDate.dayOfMonth}일",
                fontSize = 38.sp,
                color = colorResource(id = R.color.intro_text)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PrevSignUpBirthScreen() {
    SignUpBirthScreen {

    }
}