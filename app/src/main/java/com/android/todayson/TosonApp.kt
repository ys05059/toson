package com.android.todayson

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.todayson.NavDestination.CALL_ROUTE
import com.android.todayson.NavDestination.EMOTION_ROUTE
import com.android.todayson.NavDestination.HOME_ROUTE
import com.android.todayson.NavDestination.INTRO_ROUTE
import com.android.todayson.NavDestination.QUESTION_ROUTE
import com.android.todayson.NavDestination.SETTING_ROUTE
import com.android.todayson.NavDestination.SIGNUP_ROUTE
import com.android.todayson.home.CallScreen
import com.android.todayson.home.EmotionScreen
import com.android.todayson.home.HomeScreen
import com.android.todayson.home.QuestionScreen
import com.android.todayson.home.SettingScreen
import com.android.todayson.signup.SignUpRoute

@Composable
fun TosonApp(
    mainViewModel : MainViewModel = hiltViewModel()
) {
    // Creates an permission request
    val recordAudioLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            mainViewModel.setCanRecord(isGranted)
        }
    )
    LaunchedEffect(key1 = recordAudioLauncher) {
        // Launches the permission request
        recordAudioLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }
    Column(Modifier.fillMaxSize()) {
        TosonNavHost()
    }
}

@Composable
fun TosonNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = INTRO_ROUTE
    ) {
        composable(route = INTRO_ROUTE) {
            IntroScreen(
                navigateToSignUp = {
                    navController.navigate(SIGNUP_ROUTE)
                }
            )
        }

        composable(route = SIGNUP_ROUTE) {
            SignUpRoute(
                navigateToHome = {
                    navController.navigate(HOME_ROUTE)
                }
            )
        }
        composable(route = HOME_ROUTE) {
            HomeScreen(
                navigateToQuestion = { navController.navigate(QUESTION_ROUTE) },
                navigateToEmotion = { navController.navigate(EMOTION_ROUTE) },
                navigateToSetting = { navController.navigate(SETTING_ROUTE) },
                )
        }

        composable(route = QUESTION_ROUTE) {
            QuestionScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = EMOTION_ROUTE) {
            EmotionScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = SETTING_ROUTE) {
            SettingScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = CALL_ROUTE){
            CallScreen(
                onCallClick = {
                    navController.navigate(QUESTION_ROUTE)
                },
                onCloseClick = {
                    navController.navigate(HOME_ROUTE)
                }
            )
        }

    }

}

object NavDestination {
    const val INTRO_ROUTE = "intro"
    const val SIGNUP_ROUTE = "signup"
    const val HOME_ROUTE = "home"
    const val QUESTION_ROUTE = "question"
    const val EMOTION_ROUTE = "emotion"
    const val SETTING_ROUTE = "setting"
    const val CALL_ROUTE = "call"
}