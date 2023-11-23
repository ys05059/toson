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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.todayson.NavDestination.SIGNUP_ROUTE
import com.android.todayson.R
import com.android.todayson.component.RoundedButton
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
    signUpNavController: NavHostController =  rememberNavController()
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
            SignUpNameScreen {
                signUpNavController.navigate(SEX_ROUTE)
            }
        }

        composable(route = SEX_ROUTE){
            SignUpNameScreen {
                signUpNavController.navigate(START_ROUTE)
            }
        }

    }

}

@Composable
fun SignUpScaffold(
    buttonText : String = "다음 단계",
    onButtonClicked : () -> Unit = {},
    headContent : @Composable () -> Unit,
    mainContent : @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.signup_background))
    ){
        Circle(
            modifier  = Modifier.offset(x = (-75).dp, y = (-140).dp),
            size = 400.dp,
            color = colorResource(id = R.color.signup_circle)
        )

        Column(modifier = Modifier.fillMaxSize()){
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(.3f)

            ){
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 80.dp, bottom = 20.dp)
                    ,
                    color = Color.Transparent
                ) {
                    headContent()
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.7f)
                ,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp )
            ) {
                Surface(
                    modifier = Modifier.padding(horizontal = 24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                        ) {
                        mainContent()
                        RoundedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                            ,
                            basicBackgroundColor = colorResource(id = R.color.signup_bottom_button),
                            pressedBackgroundColor = colorResource(id = R.color.signup_bottom_button),
                            roundedCornerSize = 40.dp,
                            onClick = onButtonClicked
                        ) {
                            Text(
                                text = buttonText,
                                fontSize = 38.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
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