package com.syizuril.risemonsterdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syizuril.risemonsterdex.ui.components.MonsDexMain
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiseMonsterdexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val systemUiController = rememberSystemUiController()
                    val color = MaterialTheme.colors.background
                    DisposableEffect(systemUiController) {
                        systemUiController.setSystemBarsColor(
                            color = color
                        )
                        onDispose {}
                    }
                    MonsDexMain()
                }
            }
        }
    }
}