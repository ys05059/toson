package com.android.todayson.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.todayson.R
import com.android.todayson.component.CircleButton
import com.android.todayson.component.SignUpScaffold

@Composable
fun SignUpSexScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateToNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    SignUpScaffold(
        onButtonClicked = navigateToNext,
        headContent = {
            SignUpIntroText(2)
        }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("성별")
                }
                append("을 알려주세요")
            },
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            lineHeight = 60.sp,
            color = colorResource(id = R.color.intro_text)
        )
        Surface(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(150.dp),
            shape = RoundedCornerShape(12.dp),
            color = colorResource(id = R.color.signup_round_text_background)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = uiState.sex,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.intro_text)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircleButton(
                modifier = Modifier.size(150.dp),
                basicBackgroundColor = colorResource(id = R.color.signup_women_button),
                onClick = {
                    viewModel.updateSex("여자")
                }
            ) {
                Text(
                    text = "여자",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            CircleButton(
                modifier = Modifier.size(150.dp),
                basicBackgroundColor = colorResource(id = R.color.signup_man_button).copy(0.5f),
                onClick = {
                    viewModel.updateSex("남자")
                }
            ) {
                Text(
                    text = "남자",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevSignUpSexScreen() {
    SignUpSexScreen(
        navigateToNext = {}
    )
}