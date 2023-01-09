package com.syizuril.risemonsterdex.ui.components.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.ui.components.home.SplitChip

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */
@Composable
fun MonsterWeakness(
    monster: Monster,
    textColor: Color
){
    Text(
        text = "Weakness",
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
            .padding(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        {
            FlowRow(
                mainAxisSpacing = 4.dp,
                crossAxisSpacing = 4.dp,
            ) {
                SplitChip(weakness = monster.weakness, Modifier)
            }
        }
    }
}