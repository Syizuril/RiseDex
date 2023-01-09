package com.syizuril.risemonsterdex.ui.components.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.ui.components.home.MonsterDetail
import com.syizuril.risemonsterdex.ui.components.other.AutoSizeText

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */
@Composable
fun HeaderAppBar(
    monster: Monster,
    colorTheme: Color,
    backButton: () -> Unit,
    textColor: Color,
    failedConnection: Boolean,
    placeholderImage: Int
){
    ConstraintLayout() {
        val (image, thumb, name, type) = createRefs()
        Box(modifier = Modifier
            .constrainAs(image) {
                top.linkTo(parent.top)
            }
        ) {
            HeaderImageDetail(
                monster = monster,
                colorTheme = colorTheme,
                backButton = backButton,
                textColor = textColor,
                failedConnection = failedConnection,
                placeholderImage = placeholderImage
            )
        }
        Card(
            backgroundColor = MaterialTheme.colors.onSurface,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(end = 16.dp)
                .height(120.dp)
                .width(120.dp)
                .constrainAs(thumb) {
                    linkTo(image.bottom, image.bottom, bias = 1f)
                    linkTo(image.start, image.end, bias = 1f)
                }
        ) {
            MonsterDetail(
                monster = monster,
                height = 114.dp,
                width = 114.dp,
                alignment = Alignment.Center,
                modifier = Modifier.padding(4.dp)
            )
        }

        AutoSizeText(
            text = monster.name,
            color = textColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            textStyle = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(name) {
                    linkTo(thumb.top, image.bottom, bias = 0.5f)
                    linkTo(image.start, thumb.start)
                    width = Dimension.fillToConstraints
                }
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(type) {
                    linkTo(image.bottom, thumb.bottom, bias = 0.5f)
                    start.linkTo(name.start)
                    width = Dimension.wrapContent
                }
        ) {
            Row(
            ) {
                Text(
                    text = "Monster Type : ",
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2
                )

                Text(
                    text = monster.type.ifEmpty { "???" },
                    color = textColor,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2,
                )
            }

            Row(
            ) {
                Text(
                    text = "Anti Species : ",
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2
                )

                Text(
                    text = monster.antiSpecies.ifEmpty { "???" },
                    color = textColor,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}