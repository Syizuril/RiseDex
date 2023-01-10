package com.syizuril.risemonsterdex.ui.view

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme

/**
 * Created by Syekh Syihabuddin Azmil Umri on 28/12/2022.
 */
@Composable
fun About(
    upPress: () -> Unit,
    navController: NavController
){
    val systemUiController = rememberSystemUiController()
    val color = MaterialTheme.colors.onSurface
    DisposableEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = color
        )
        onDispose {}
    }
    Column() {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.onSurface,
            elevation = 0.dp,
            contentColor = MaterialTheme.colors.surface,
            modifier = Modifier.statusBarsPadding()
        ) {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back Button",
                    tint = MaterialTheme.colors.surface
                )
            }
            Text(
                text = stringResource(R.string.about_app),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            ConstraintLayout(modifier = Modifier
                .padding(top = 58.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                val (imageProfile, card) = createRefs()

                Card(
                    backgroundColor = MaterialTheme.colors.onSurface,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(card) {
                            linkTo(start = parent.start, end = parent.end)
                        }) {
                    Column(modifier = Modifier
                        .padding(top=50.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.what_is_risedex),
                            color = MaterialTheme.colors.surface,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        Text(
                            text = stringResource(R.string.risedex_desc),
                            color = MaterialTheme.colors.surface,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_round),
                    contentDescription = "dev image profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .height(100.dp)
                        .width(100.dp)
                        .constrainAs(imageProfile) {
                            linkTo(card.top, card.top, bias = 1f)
                            linkTo(card.start, card.end)
                        }
                )
            }

            Card(
                backgroundColor = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            ){
                Column() {
                    Text(
                        text = stringResource(R.string.disclaimer_title),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.disclaimer_desc),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 4.dp)
                    )
                }
            }

            Card(
                backgroundColor = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            ){
                Column() {
                    Text(
                        text = stringResource(R.string.legal),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.legal_desc),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 4.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        OutlinedButton(
                            border = BorderStroke(1.dp, MaterialTheme.colors.background),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background, backgroundColor = MaterialTheme.colors.onSurface),
                            onClick = {
                                navController.navigate("privacy/privacypolicy.md")
                            },
                        ) {
                            Text(text = stringResource(R.string.privacypolicy),
                                color = MaterialTheme.colors.surface,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                        OutlinedButton(
                            border = BorderStroke(1.dp, MaterialTheme.colors.background),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background, backgroundColor = MaterialTheme.colors.onSurface),
                            onClick = {
                                navController.navigate("privacy/termscondition.md")
                            },
                        ) {
                            Text(text = stringResource(R.string.termscondition),
                                color = MaterialTheme.colors.surface,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(8.dp))
                        }
                    }
                }
            }

            Card(
                backgroundColor = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            ){
                Column() {
                    Text(
                        text = stringResource(R.string.support),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.support_desc),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 4.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        val context = LocalContext.current
                        OutlinedButton(
                            border = BorderStroke(1.dp, MaterialTheme.colors.background),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background, backgroundColor = MaterialTheme.colors.onSurface),
                            onClick = {
                                  context.sendMail(
                                      to = "syekh.syihabuddin@gmail.com",
                                      subject = "RiseDex Support"
                                  )
                            },
                        ) {
                            Text(text = "Contact Me",
                                color = MaterialTheme.colors.surface,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                        OutlinedButton(
                            border = BorderStroke(1.dp, MaterialTheme.colors.background),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.background, backgroundColor = MaterialTheme.colors.onSurface),
                            onClick = {
                                context.openRepository()
                            },
                        ) {
                            Text(text = "Repository Github",
                                color = MaterialTheme.colors.surface,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(8.dp))
                        }
                    }
                }
            }
        }
    }
}

fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Log.d("MAIL ERROR", "Activity Not Found")
    } catch (t: Throwable) {
        Log.d("MAIL ERROR", "Error : "+t.message)
    }
}

fun Context.openRepository(){
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Syizuril/RiseDex"))
        startActivity(intent)
    }catch (e: Throwable) {
        Log.d("MAIL ERROR", "Error : "+e.message)
    }
}