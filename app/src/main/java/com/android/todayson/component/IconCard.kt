package com.android.todayson.component

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun IconCard(
    modifier : Modifier = Modifier,
    @DrawableRes iconId : Int,
    @ColorRes colorId : Int,
) {
    Card(
        modifier = modifier.size(180.dp),
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = colorId)
        )
    ){
        Image(
            modifier = modifier
                .fillMaxSize()
                .padding(40.dp) ,
            painter = painterResource(id = iconId),
            contentDescription = null
        )

    }
}