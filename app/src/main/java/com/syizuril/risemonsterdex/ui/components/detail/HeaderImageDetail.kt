package com.syizuril.risemonsterdex.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */
@Composable
fun HeaderImageDetail(
    monster: Monster,
    colorTheme: Color,
    backButton: () -> Unit,
    textColor: Color,
    failedConnection: Boolean,
    placeholderImage: Int
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        var sizeImage by remember { mutableStateOf(IntSize.Zero) }

        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Transparent, colorTheme),
            startY = sizeImage.height.toFloat() / 3,  // 1/3
            endY = sizeImage.height.toFloat()
        )

        AsyncImage(
            model = if(failedConnection){
                    placeholderImage
                }else{
                    monster.image
                     },
            contentDescription = "thumbnail",
            contentScale = ContentScale.Crop,
            error = painterResource(id = placeholderImage),
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    sizeImage = it.size
                }
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(gradient)
        )
    }

    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        contentColor = Color.White,
        modifier = Modifier.statusBarsPadding()
    ) {
        IconButton(onClick = backButton) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back Button",
                tint = textColor
            )
        }

    }
}