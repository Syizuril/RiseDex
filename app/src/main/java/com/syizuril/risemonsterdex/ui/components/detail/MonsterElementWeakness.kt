package com.syizuril.risemonsterdex.ui.components.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.ui.components.other.BarChart

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */
@Composable
fun MonsterElementWeakness(
    monster: Monster,
    colorTheme: Color,
    textColor: Color,
    captionColor: Color
){
    Text(
        text = "Average Element Weakness (eHZV)",
        color = textColor,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .padding(bottom = 8.dp, top = 8.dp)
            .fillMaxWidth()
    )
    Card(
        backgroundColor = MaterialTheme.colors.onSurface,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val maxValue =
                maxOf(monster.fire, monster.water, monster.thunder, monster.ice, monster.dragon)
            BarChart(
                icon = painterResource(id = R.drawable.fire_element),
                value = monster.fire,
                colorTheme = colorTheme,
                max = maxValue,
                textColor = captionColor,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )
            BarChart(
                icon = painterResource(id = R.drawable.water_element),
                value = monster.water,
                colorTheme = colorTheme,
                textColor = captionColor,
                max = maxValue,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            BarChart(
                icon = painterResource(id = R.drawable.thunder_element),
                value = monster.thunder,
                colorTheme = colorTheme,
                textColor = captionColor,
                max = maxValue,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            BarChart(
                icon = painterResource(id = R.drawable.ice_element),
                value = monster.ice,
                colorTheme = colorTheme,
                textColor = captionColor,
                max = maxValue,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            BarChart(
                icon = painterResource(id = R.drawable.dragon_element),
                value = monster.dragon,
                colorTheme = colorTheme,
                textColor = captionColor,
                max = maxValue,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
            )
        }
    }
}