package com.syizuril.risemonsterdex.ui.view

import androidx.activity.ComponentActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.syizuril.risemonsterdex.model.Monster
import com.syizuril.risemonsterdex.ui.theme.RiseMonsterdexTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Syekh Syihabuddin Azmil Umri on 29/12/2022.
 */
class MonsterDetailKtTest{
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeMonster = Monster(
        "Malzeno",
        "Anti-Aerial",
        "Elder Dragon",
        "Dragon",
        "",
        "Head",
        "Foreleg",
        12,
        0,
        0,
        8,
        19,
        "Head + Foreleg + Tail Tip",
        "Head + Foreleg + Tail Tip",
        "Head + Foreleg",
        41,
        39,
        24,
        "https://assets2.rockpapershotgun.com/malzeno-head.png/BROK/resize/1920x1920%3E/format/jpg/quality/80/malzeno-head.png",
        "https://static.wikia.nocookie.net/monsterhunter/images/2/24/MHRS-Malzeno_Icon.png/revision/latest/?cb=20220615153147",
        "A dragon covered with elegant silver scales. It uses the Qurio to drain the life energy of other living creatures, creeping around at night and attacking its prey from behind. It appears almost regal to start with, but after draining enough energy it can turn a violent, fresh-blood crimson. This form is known as the \"Bloodening\" and is widely feared."
    )

    @Before
    fun setUp(){
        composeTestRule.setContent {
            RiseMonsterdexTheme() {
                MonsterDetail(monsterName = fakeMonster.name, backButton = {})
            }
        }
    }

    @Test
    fun detailMonster_isDisplayed(){
        composeTestRule.waitUntil {
            composeTestRule
                .onAllNodesWithText(fakeMonster.name)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText(fakeMonster.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeMonster.antiSpecies).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeMonster.type).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeMonster.weakness).assertIsDisplayed()
        composeTestRule.onAllNodes(hasTestTag("eHVZ"))[0].assertExists(fakeMonster.eHZV25)
        composeTestRule.onAllNodes(hasTestTag("eHVZ"))[1].assertExists(fakeMonster.eHZV30)
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[0].assertExists(fakeMonster.water.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[1].assertExists(fakeMonster.water.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[2].assertExists(fakeMonster.thunder.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[3].assertExists(fakeMonster.ice.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[4].assertExists(fakeMonster.thunder.toString())
        composeTestRule.onAllNodes(hasTestTag("eHVZ"))[2].assertExists(fakeMonster.sword)
        composeTestRule.onAllNodes(hasTestTag("eHVZ"))[3].assertExists(fakeMonster.hammer)
        composeTestRule.onAllNodes(hasTestTag("eHVZ"))[4].assertExists(fakeMonster.bow)
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[5].assertExists(fakeMonster.rHVZsword.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[6].assertExists(fakeMonster.rHVZhammer.toString())
        composeTestRule.onAllNodes(hasTestTag("chartValue"))[7].assertExists(fakeMonster.rHVZbow.toString())
    }
}