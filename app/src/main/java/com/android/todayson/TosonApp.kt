package com.android.todayson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.todayson.IntroScreen
import com.android.todayson.NavDestination.INTRO_ROUTE
import com.android.todayson.NavDestination.SIGNUP_ROUTE
import com.android.todayson.signup.SignUpRoute

@Composable
fun TosonApp(

) {
    Column(Modifier.fillMaxSize()) {
        TosonNavHost()
    }
}

@Composable
fun TosonNavHost(
    navController: NavHostController =  rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = INTRO_ROUTE
    ){
        composable(route = INTRO_ROUTE){
            IntroScreen(
                navigateToSignUp = {
                    navController.navigate(SIGNUP_ROUTE)
                }
            )
        }

        composable(route = SIGNUP_ROUTE){
            SignUpRoute()
        }

    }

}

object NavDestination {
    const val INTRO_ROUTE = "intro"
    const val SIGNUP_ROUTE = "signup"
    const val HOME_ROUTE = "home"
    const val QUESTION_ROUTE = "question"
    const val SETTING_ROUTE = "setting"
}