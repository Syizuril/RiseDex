package com.syizuril.risemonsterdex.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.syizuril.risemonsterdex.navigation.Screen
import com.syizuril.risemonsterdex.ui.view.PrivacyPolicy
import com.syizuril.risemonsterdex.ui.view.About
import com.syizuril.risemonsterdex.ui.view.Home
import com.syizuril.risemonsterdex.ui.view.MonsterDetail

/**
 * Created by Syekh Syihabuddin Azmil Umri on 26/12/2022.
 */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MonsDexMain(){
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController, startDestination = Screen.Home.route) {
        composable(
            Screen.Home.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ){
            Home(navController = navController)
        }
        composable(
            Screen.About.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
        ){
            About (upPress = {navController.navigateUp()}, navController= navController)
        }
        composable(
            "${Screen.PrivacyPolicy.route}/{fileName}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            arguments = listOf(navArgument("fileName"){type = NavType.StringType})
        ){
            PrivacyPolicy(
                fileName = it.arguments?.getString("fileName")?:"null",
                upPress = {navController.navigateUp()})
        }
        composable(
            "${Screen.MonsterDetail.route}/{name}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            arguments = listOf(navArgument("name"){type = NavType.StringType})
        ){
            MonsterDetail(
                monsterName = it.arguments?.getString("name")?:"null",
                backButton = {navController.navigateUp()})
        }
    }
}