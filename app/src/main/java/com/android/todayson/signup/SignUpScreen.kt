package com.android.todayson.signup

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.todayson.NavDestination.SIGNUP_ROUTE
import com.android.todayson.R
import com.android.todayson.component.RoundedButton
import com.android.todayson.component.SignUpScaffold
import com.android.todayson.signup.SignUpNavDestination.ALARM_ROUTE
import com.android.todayson.signup.SignUpNavDestination.BIRTH_ROUTE
import com.android.todayson.signup.SignUpNavDestination.COMPLETE_ROUTE
import com.android.todayson.signup.SignUpNavDestination.NAME_ROUTE
import com.android.todayson.signup.SignUpNavDestination.SEX_ROUTE
import com.android.todayson.signup.SignUpNavDestination.START_ROUTE

object SignUpNavDestination {
    const val START_ROUTE = "start"
    const val NAME_ROUTE = "name"
    const val SEX_ROUTE = "sex"
    const val BIRTH_ROUTE = "birth"
    const val ALARM_ROUTE = "alarm"
    const val COMPLETE_ROUTE = "complete"
}

@Composable
fun SignUpRoute(
    signUpNavController: NavHostController =  rememberNavController(),
    navigateToHome : () -> Unit = {}
) {
    NavHost(
        navController = signUpNavController,
        startDestination = START_ROUTE,
        route = SIGNUP_ROUTE
    ){
        composable(route = START_ROUTE){
            SignUpStartScreen(
                navigateToNext = {
                    signUpNavController.navigate(NAME_ROUTE)
                }
            )
        }

        composable(route = NAME_ROUTE){
            SignUpNameScreen{
                signUpNavController.navigate(SEX_ROUTE)
            }
        }

        composable(route = SEX_ROUTE){
            SignUpSexScreen {
                signUpNavController.navigate(BIRTH_ROUTE)
            }
        }

        composable(route = BIRTH_ROUTE){
            SignUpBirthScreen{
                signUpNavController.navigate(ALARM_ROUTE)
            }
        }

        composable(route = ALARM_ROUTE){
            SignUpAlarmScreen{
                signUpNavController.navigate(COMPLETE_ROUTE)
            }
        }

        composable(route = COMPLETE_ROUTE){
            SignUpCompleteScreen (
                navigateToNext = navigateToHome
            )
        }
    }

}


@Composable
fun Circle(
    modifier : Modifier = Modifier,
    size: Dp = 40.dp,
    color: Color = Color.Blue
) {
    Canvas(modifier = modifier.size(size)) {
        drawCircle(
            color = color,
            radius = size.toPx() / 2,
            center = Offset(size.toPx() / 2, size.toPx() / 2)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PrevSignUpScaffold() {
    SignUpScaffold(
        buttonText = "시작하기",
        headContent = {}) {
    }
}

@Preview(showBackground = true)
@Composable
fun PrevCircle() {
    Circle()
}