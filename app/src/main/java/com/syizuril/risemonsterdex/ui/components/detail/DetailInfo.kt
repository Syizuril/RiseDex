package com.syizuril.risemonsterdex.ui.components.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */

@Composable
fun DetailInfo(
    monster: Monster,
    colorTheme: Color,
    textColor: Color,
    backButton: () -> Unit,
    captionColor: Color,
    failedConnection: Boolean,
    placeholderImage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        HeaderAppBar(
            monster = monster,
            colorTheme = colorTheme,
            backButton = backButton,
            textColor = textColor,
            failedConnection = failedConnection,
            placeholderImage = placeholderImage
        )
        MonsterDesc(
            monster = monster,
            captionColor = captionColor,
            textColor = textColor
        )
        MonsterWeakness(
            monster = monster,
            textColor = textColor
        )
        MonsterElementWeakness(
            monster = monster,
            colorTheme = colorTheme,
            textColor = textColor,
            captionColor = captionColor
        )
        MonsterElementExploit(
            monster = monster,
            colorTheme = colorTheme,
            textColor = textColor,
            captionColor = captionColor
        )
        MonsterRawWeakness(
            monster = monster,
            colorTheme = colorTheme,
            textColor = textColor,
            captionColor = captionColor
        )
        MonsterExploitArea(
            monster = monster,
            colorTheme = colorTheme,
            textColor = textColor,
            captionColor = captionColor
        )
    }
}