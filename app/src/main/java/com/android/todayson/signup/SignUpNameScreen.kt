package com.android.todayson.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SignUpNameScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateToNext : () -> Unit
) {
    val voiceToTextParserState by viewModel.voiceToTextParserState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = voiceToTextParserState.spokenText){
        viewModel.updateName( voiceToTextParserState.spokenText)
    }
    DisposableEffect(key1 = Unit){
        onDispose {
            if(voiceToTextParserState.isSpeaking){
                viewModel.stopListening()
            }
            viewModel.resetVoiceToTextParser()
        }
    }

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = buildAnnotatedString {
                    withStyle(style =  SpanStyle(
                        fontWeight = FontWeight.Bold,
                    )
                    ){
                        append("성함 :")
                    }
                },
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                color = colorResource(id = R.color.intro_text)
            )

            Surface(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(12.dp),
                color = colorResource(id = R.color.signup_round_text_background)
            ){
                BasicTextField(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxWidth(),
                    value = uiState.name,
                    onValueChange = { viewModel.updateName(it) } ,
                    textStyle =  MaterialTheme.typography.headlineLarge,
                )
            }
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleButton(
                modifier = Modifier.size(180.dp),
                basicBackgroundColor = colorResource(id = R.color.yellow),
                enabled = true,
                onClick = {
                    if(!voiceToTextParserState.isSpeaking)
                        viewModel.startListening()
                    else viewModel.stopListening()
                }
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp) ,
                    painter = painterResource(id = R.drawable.microphone),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text =  if (voiceToTextParserState.isSpeaking) "듣고 있어요!"
                else if (voiceToTextParserState.spokenText.isEmpty()) "말씀해주세요"
                else "",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 28.sp,
                lineHeight = 60.sp,
                color = colorResource(id = R.color.intro_text),
                textAlign = TextAlign.Center,
            )
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
        viewModel = hiltViewModel(),
        {}
    )

}