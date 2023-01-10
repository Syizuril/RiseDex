package com.syizuril.risemonsterdex.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.ui.theme.blueBG
import java.io.InputStream

@Composable
fun PrivacyPolicy(
    fileName: String,
    modifier: Modifier = Modifier,
    upPress: () -> Unit
){
    val systemUiController = rememberSystemUiController()
    val color = MaterialTheme.colors.onSurface
    DisposableEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = color
        )
        onDispose {}
    }
    var dataText by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    LaunchedEffect(true) {
        kotlin.runCatching {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            String(buffer)
        }.onSuccess {
            dataText = it
        }.onFailure {
            dataText = "error"
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(blueBG)
    ) {
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
                text = if(fileName=="privacypolicy.md") stringResource(id = R.string.privacy_policy) else stringResource(
                    id = R.string.termscondition
                ),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
            )
        }
        RichText(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Markdown(
                content = dataText
            )
        }
    }
}