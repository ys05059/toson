package com.android.todayson.ui.home

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.todayson.R
import com.android.todayson.ui.signup.Circle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(
    viewModel: QuestionViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val voiceToTextParserState by viewModel.voiceToTextParserState.collectAsState()
    DisposableEffect(key1 = Unit){
        onDispose {
            if(voiceToTextParserState.isSpeaking){
                viewModel.stopListening()
            }
            viewModel.resetVoiceToTextParser()
        }
    }
    QuestionScaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            ArrowBackRow(
                onBackClick = onBackClick
            )
            TalkBubble(
                modifier = Modifier.weight(.4f),
                text = "오늘 뭐 드시고\n싶으세요?"
            )
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .size(160.dp),
                    onClick = {
                        if (!voiceToTextParserState.isSpeaking) {
                            viewModel.startListening()
                        } else {
                            viewModel.stopListening()
                        }
                    },
                    shape = CircleShape,
                    color = Color.Transparent
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        painter = painterResource(id = R.drawable.microphone),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = if (voiceToTextParserState.isSpeaking) "듣고 있어요!"
                    else if (voiceToTextParserState.spokenText.isEmpty()) "말씀해주세요"
                    else voiceToTextParserState.spokenText,
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 38.sp,
                    lineHeight = 60.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun QuestionScaffold(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.background_gradient_start),
                        colorResource(id = R.color.background_gradient_end)
                    )
                )
            )
    ) {
        Circle(
            modifier = Modifier.offset(x = (75).dp, y = (-140).dp),
            size = 500.dp,
            color = colorResource(id = R.color.question_circle).copy(0.11f)
        )
        content()
    }
}

@Composable
fun TalkBubble(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.speech_bubble),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArrowBackRow(
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Surface(
            onClick = onBackClick,
            shape = CircleShape,
            modifier = Modifier.size(72.dp),
            color = colorResource(id = R.color.arrow_back)
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevQuestionScreen() {
    QuestionScreen(
        onBackClick = {}
    )

}