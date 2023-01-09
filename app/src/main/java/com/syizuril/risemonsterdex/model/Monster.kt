package com.syizuril.risemonsterdex.model

/**
 * Created by Syekh Syihabuddin Azmil Umri on 19/12/2022.
 */
data class Monster(
    val name : String,
    val antiSpecies : String,
    val type : String,
    val weakness : String,
    val eHZV35 : String,
    val eHZV30 : String,
    val eHZV25 : String,
    val fire : Int,
    val water : Int,
    val thunder : Int,
    val ice : Int,
    val dragon : Int,
    val sword : String,
    val hammer : String,
    val bow : String,
    val rHVZsword : Int,
    val rHVZhammer : Int,
    val rHVZbow : Int,
    val image : String,
    val thumb : String,
    val desc : String
)