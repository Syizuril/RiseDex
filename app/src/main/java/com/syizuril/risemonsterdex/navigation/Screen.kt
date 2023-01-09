package com.syizuril.risemonsterdex.navigation

import androidx.annotation.StringRes
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 26/12/2022.
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.text_home)
    object About : Screen("about", R.string.about)
    object MonsterDetail : Screen("details", R.string.text_details)
    object PrivacyPolicy : Screen("privacy", R.string.privacy_policy)
}