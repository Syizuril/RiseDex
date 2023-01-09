package com.syizuril.risemonsterdex.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.model.FakeMonsterDataSource
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme

/**
 * Created by Syekh Syihabuddin Azmil Umri on 19/12/2022.
 */

@Composable
fun MonsterItem(
    monster: Monster,
    onItemClicked: (monster: Monster) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable (onClick = {onItemClicked(monster)}),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Column(modifier = Modifier.align(CenterVertically)) {
                Text(
                    text = monster.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.body2
                )
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
                Text(
                    text = buildString {
                        append(monster.type.ifEmpty { "???" })
                        append(" | ")
                        append(monster.antiSpecies.ifEmpty { "???" })
                    },
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(0.dp, 0.dp, 16.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.overline
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            WeaknessElementTag(weakness = monster.weakness, modifier = modifier.align(CenterVertically))
            Spacer(modifier = Modifier.padding(2.dp))
            MonsterDetail(monster = monster, height = 40.dp, width = 40.dp, alignment = Alignment.CenterEnd)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MonsterItemPreview(){
    RiseMonsterdexTheme{
        MonsterItem(FakeMonsterDataSource.dummyMonster[0],{})
    }
}

@Composable
fun getPainter(weakness: String): Painter {
    return with(weakness){
        when {
            contains(
                stringResource(id = R.string.dragon),
                true
            ) -> painterResource(id = R.drawable.dragon_frame)
            contains(stringResource(id = R.string.fire), true) -> painterResource(id = R.drawable.fire_frame)
            contains(stringResource(id = R.string.ice), true) -> painterResource(id = R.drawable.water_frame)
            contains(
                stringResource(id = R.string.thunder),
                true
            ) -> painterResource(id = R.drawable.thunder_frame)
            contains(stringResource(id = R.string.water), true) -> painterResource(id = R.drawable.ice_frame)
            else -> painterResource(id = R.drawable.dragon_frame)
        }
    }
}

