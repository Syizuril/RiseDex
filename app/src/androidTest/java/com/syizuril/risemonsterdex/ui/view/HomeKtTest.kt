package com.syizuril.risemonsterdex.ui.view

import androidx.activity.ComponentActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.model.FakeMonsterDataSource
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.navigation.Screen
import com.syizuril.risemonsterdex.onNodeWithStringId
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Syekh Syihabuddin Azmil Umri on 29/12/2022.
 */
class HomeKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @OptIn(ExperimentalAnimationApi::class)
    @Before
    fun setUp() {
        composeTestRule.setContent {
            RiseMonsterdexTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(AnimatedComposeNavigator())
                Home(navController = navController)
            }
        }
    }

    @Test
    fun home_isDisplayed(){
        composeTestRule.onNodeWithTag("MonsterList").performScrollToIndex(15)
        composeTestRule.onNodeWithText("Basarios").assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Flying Wyvern | Anti-Dragon"))[0].assertIsDisplayed()
        composeTestRule.onNodeWithText("Dragon").assertIsDisplayed()
        composeTestRule.onNodeWithTag("MonsterList").performScrollToIndex(0)
        composeTestRule.onNodeWithStringId(R.string.app_name).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.app_desc).assertIsDisplayed()
    }

    @Test
    fun home_searchMonster(){
        composeTestRule.onNodeWithTag("SearchMonster").performTextInput("Arzuros")
        composeTestRule.onAllNodes(hasText("Arzuros"))[1].assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Fanged Beast | Fanged Exploit"))[0].assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Fire"))[0].assertIsDisplayed()
        composeTestRule.onNodeWithTag("SearchMonster").performTextClearance()
        composeTestRule.onNodeWithText("Aknosom").assertIsDisplayed()
    }
}