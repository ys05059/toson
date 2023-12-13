package com.android.todayson.ui.signup

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.todayson.ui.NavDestination.SIGNUP_ROUTE
import com.android.todayson.ui.component.SignUpScaffold
import com.android.todayson.ui.signup.SignUpNavDestination.ALARM_ROUTE
import com.android.todayson.ui.signup.SignUpNavDestination.BIRTH_ROUTE
import com.android.todayson.ui.signup.SignUpNavDestination.COMPLETE_ROUTE
import com.android.todayson.ui.signup.SignUpNavDestination.NAME_ROUTE
import com.android.todayson.ui.signup.SignUpNavDestination.SEX_ROUTE
import com.android.todayson.ui.signup.SignUpNavDestination.START_ROUTE

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