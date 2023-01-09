package com.syizuril.risemonsterdex.ui.components.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.syizuril.risemonsterdex.R

/**
 * Created by Syekh Syihabuddin Azmil Umri on 26/12/2022.
 */
@Composable
fun BarDesc(
    title: Any,
    value: String,
    colorTheme: Color,
    textColor: Color,
    modifier: Modifier = Modifier
){
    Row(){
        Box(
            modifier = modifier
                .height(40.dp)
                .padding(start  = 16.dp)
                .clip(RoundedCornerShape(8.dp, 0.dp,0.dp,8.dp))
                .background(colorTheme.copy(0.8f))
        ){
            if(title is String){
                Text(
                    text = title,
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }else{
                Image(
                    painter = title as Painter,
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Box(
            modifier = modifier
                .padding(
                    end = 16.dp,
                )
                .clip(RoundedCornerShape(0.dp, 8.dp,8.dp,0.dp))
                .height(40.dp)
                .fillMaxWidth()
                .background(colorTheme.copy(0.5f))
        ){
            Text(
                text = value,
                color = textColor,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterStart)
                    .testTag("eHVZ")
            )
        }
    }
}