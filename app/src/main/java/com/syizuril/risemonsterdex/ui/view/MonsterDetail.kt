package com.syizuril.risemonsterdex.ui.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syizuril.risemonsterdex.ui.viewmodel.MonsterDetailViewModel
import com.syizuril.risemonsterdex.ui.viewmodel.MonsterDetailViewModelFactory
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.data.MonsterRepository
import com.syizuril.risemonsterdex.model.FakeMonsterDataSource
import com.syizuril.risemonsterdex.ui.components.detail.DetailInfo
import com.syizuril.risemonsterdex.ui.components.detail.LoadingTheme
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme
import com.syizuril.risemonsterdex.ui.theme.blueText
import com.syizuril.risemonsterdex.ui.theme.cardNight


/**
 * Created by Syekh Syihabuddin Azmil Umri on 25/12/2022.
 */
@Composable
fun MonsterDetail(
    monsterName: String,
    backButton: () -> Unit,
    viewModel: MonsterDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = MonsterDetailViewModelFactory(
            MonsterRepository()
        )
    )
) {
    var isLoading by remember { mutableStateOf(true) }
    val monster = viewModel.getMonsterByName(monsterName)
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var colorPalette by remember { mutableStateOf<Palette?>(null) }
    var colorTheme by remember { mutableStateOf<Color?>(blueText) }
    var textColor by remember { mutableStateOf<Color?>(blueText) }
    bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ice_frame)
    var captionColor by remember { mutableStateOf<Color?>(blueText) }
    val listMeme = listOf(
        R.drawable.meme_satu,
        R.drawable.meme_dua,
        R.drawable.meme_tiga,
    ).random()
    var failedConnection by remember { mutableStateOf<Boolean>(false) }
    val isDark = isSystemInDarkTheme()
    LaunchedEffect(key1 = monster.name) {
        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(monster.image)
            .error(listMeme)
            .target(
                onSuccess = { result ->
                    bitmap = (result as BitmapDrawable).bitmap
                },
                onError = {
                    bitmap = ResourcesCompat.getDrawable(context.resources, listMeme, context.theme)?.toBitmap()
                    failedConnection = true
                }
            )
            .allowHardware(false) // Disable hardware bitmaps.
            .build()
        try {
            val result = (loader.execute(request) as SuccessResult).drawable
            bitmap = (result as BitmapDrawable).bitmap
        }catch(e: ClassCastException){
            bitmap = ResourcesCompat.getDrawable(context.resources, listMeme, context.theme)?.toBitmap()
            failedConnection = true
        }
        colorPalette = bitmap?.let { Palette.from(it).generate() }
        colorTheme = colorPalette?.dominantSwatch?.rgb?.let { lerp(Color(it), Color.White, 0.3f) } ?: cardNight
        textColor = if (ColorUtils.calculateLuminance(colorTheme!!.toArgb()) < 0.5) {
            colorPalette?.lightVibrantSwatch?.rgb?.let { Color(it) } ?: blueText
        } else {
            colorPalette?.darkMutedSwatch?.rgb?.let { Color(it) } ?: blueText
        }
        captionColor = if (isDark) {
            val lightVibrant = colorPalette?.lightVibrantSwatch?.rgb?.let { Color(it) } ?: blueText
            if (ColorUtils.calculateLuminance(lightVibrant.toArgb()) < 0.5 )
                Color(ColorUtils.blendARGB(lightVibrant.toArgb(), Color.White.toArgb(), 0.5f)) else {
                colorPalette?.lightVibrantSwatch?.rgb?.let { Color(it) } ?: blueText
            }
        } else {
            colorPalette?.darkMutedSwatch?.rgb?.let { Color(it) } ?: blueText
        }
        systemUiController.setSystemBarsColor(
            color = colorTheme ?: blueText
        )
        isLoading = false
    }
    if (isLoading) {
        LoadingTheme()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorTheme ?: MaterialTheme.colors.surface)
        ) {
            DetailInfo(
                monster = monster,
                colorTheme = colorTheme ?: MaterialTheme.colors.onSurface,
                textColor = textColor ?: MaterialTheme.colors.surface,
                backButton = backButton,
                captionColor = captionColor ?: MaterialTheme.colors.surface,
                failedConnection = failedConnection,
                placeholderImage = listMeme
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun MonsterDetailPreview() {
    RiseMonsterdexTheme() {
        MonsterDetail(monsterName = FakeMonsterDataSource.dummyMonster[46].name, {})
    }
}