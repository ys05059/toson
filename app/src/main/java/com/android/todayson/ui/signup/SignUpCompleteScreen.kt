package com.android.todayson.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R
import kotlinx.coroutines.delay

@Composable
fun SignUpCompleteScreen(
    navigateToNext : () -> Unit
) {
    LaunchedEffect(key1 = Unit){
        delay(3000)
        navigateToNext()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.signup_background)),
        contentAlignment = Alignment.Center
    ) {
        Circle(
            modifier = Modifier,
            size = 400.dp,
            color = colorResource(id = R.color.signup_complete_circle1)
        )
        Circle(
            modifier = Modifier,
            size = 320.dp,
            color = colorResource(id = R.color.signup_complete_circle2)
        )
        Text(
            text = "회원가입을\n완료했어요!",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 44.sp,
            lineHeight = 60.sp,
            color = colorResource(id = R.color.intro_text)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PrevSignUpCompleteScreen() {
    SignUpCompleteScreen {

    }

}