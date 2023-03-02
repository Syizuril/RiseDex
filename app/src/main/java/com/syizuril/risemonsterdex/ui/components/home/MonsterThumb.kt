package com.syizuril.risemonsterdex.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 25/12/2022.
 */
@Composable
fun MonsterDetail(
    monster: Monster,
    modifier: Modifier = Modifier,
    height: Dp = 40.dp,
    width: Dp = 40.dp,
    alignment: Alignment
){
    Box(
        contentAlignment = alignment,
        modifier = modifier
    ){
        Image(
            painter = getPainter(weakness = monster.weakness),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        AsyncImage(model = monster.thumb,
            contentDescription = "thumbnail",
            contentScale = ContentScale.Fit,
            error = painterResource(R.drawable.monster_unknown),
            modifier = Modifier
                .height(height)
                .width(width)
                .padding(4.dp)
                .align(Alignment.Center)
        )
    }
}