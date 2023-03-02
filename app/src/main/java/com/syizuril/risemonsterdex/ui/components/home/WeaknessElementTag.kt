package com.syizuril.risemonsterdex.ui.components.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import com.syizuril.risemonsterdex.R

/**
 * Created by Syekh Syihabuddin Azmil Umri on 20/12/2022.
 */
@Composable
fun WeaknessElementTag(weakness: String, modifier: Modifier = Modifier){
    val configuration = LocalConfiguration.current
    when(configuration.orientation){
        Configuration.ORIENTATION_PORTRAIT -> {
            FlowColumn(
                mainAxisSpacing = 2.dp,
                crossAxisSpacing = 2.dp,
                modifier = modifier
            ) {
                SplitChip(weakness = weakness, modifier = modifier)
            }
        }
        else -> {
            FlowRow(
                mainAxisSpacing = 2.dp,
                crossAxisSpacing = 2.dp,
                modifier = modifier
            ) {
                SplitChip(weakness = weakness, modifier = modifier)
            }
        }
    }
}

@Composable
fun SplitChip(weakness: String, modifier: Modifier)
{
    val weakSplitted = weakness.split(", ")
    weakSplitted.forEach{
        val color = when(it.lowercase()){
            stringResource(id = R.string.fire) -> R.color.fire
            stringResource(id = R.string.water) -> R.color.water
            stringResource(id = R.string.thunder) -> R.color.thunder
            stringResource(id = R.string.ice) -> R.color.ice
            stringResource(id = R.string.dragon) -> R.color.dragon
            else -> R.color.black
        }
        ChipText(weakness = it, color = colorResource(id = color), modifier = modifier)
    }
}

@Composable
fun ChipText(weakness: String, color: Color, modifier: Modifier = Modifier)
{
    Row(
        modifier = modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(.08f)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = modifier.padding(4.dp))
        Image(
            painter = getElementIcon(weakness = weakness),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = modifier.size(16.dp)
        )
        Text(
            text = weakness,
            color = color,
            style = MaterialTheme.typography.caption,
            modifier = modifier
                .padding(4.dp, 4.dp, 8.dp, 4.dp)
        )
    }
}

@Composable
fun getElementIcon(weakness: String): Painter {
    return with(weakness){
        when {
            contains(
                stringResource(id = R.string.dragon),
                true
            ) -> painterResource(id = R.drawable.dragon_element)
            contains(stringResource(id = R.string.fire), true) -> painterResource(id = R.drawable.fire_element)
            contains(stringResource(id = R.string.ice), true) -> painterResource(id = R.drawable.ice_element)
            contains(
                stringResource(id = R.string.thunder),
                true
            ) -> painterResource(id = R.drawable.thunder_element)
            contains(stringResource(id = R.string.water), true) -> painterResource(id = R.drawable.water_element)
            else -> painterResource(id = R.drawable.dragon_element)
        }
    }
}