package com.android.todayson.component

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.todayson.R
import com.android.todayson.signup.Circle


@Composable
fun SignUpScaffold(
    buttonText : String = "다음 단계",
    onButtonClicked : () -> Unit = {},
    sheetWeight :Float = 0.7f,
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
                .weight(1-sheetWeight)

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
                    .weight(sheetWeight)
                ,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp )
            ) {
                Surface(
                    modifier = Modifier.padding(horizontal = 24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp),
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