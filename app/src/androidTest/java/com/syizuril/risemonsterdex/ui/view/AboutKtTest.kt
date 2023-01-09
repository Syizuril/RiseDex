package com.syizuril.risemonsterdex.ui.view

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.onNodeWithStringId
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Syekh Syihabuddin Azmil Umri on 29/12/2022.
 */
class AboutKtTest{
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            RiseMonsterdexTheme() {
                About {}
            }
        }
    }

    @Test
    fun about_isDisplayed(){
        composeTestRule.onNodeWithStringId(R.string.about_app).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.what_is_risedex).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.risedex_desc).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.disclaimer_title).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.disclaimer_desc).assertIsDisplayed()
        composeTestRule.onNodeWithTag("contact").assertExists("Contact Me")
        composeTestRule.onNodeWithTag("email_title").assertExists("Syekh Syihabuddin Azmil Umri")
        composeTestRule.onNodeWithTag("email_desc").assertExists("syihabklayan@gmail.com")
    }
}