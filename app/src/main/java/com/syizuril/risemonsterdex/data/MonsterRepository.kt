package com.syizuril.risemonsterdex.data

import com.syizuril.risemonsterdex.model.FakeMonsterDataSource
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 19/12/2022.
 */
class MonsterRepository {
    fun getMonster(): List<Monster>{
        return FakeMonsterDataSource.dummyMonster
    }

    fun getMonsterByName(name: String): Monster {
        return FakeMonsterDataSource.dummyMonster.find {it.name == name} ?: FakeMonsterDataSource.dummyMonster[0]
    }

    fun searchMonster(query: String): List<Monster>{
        return FakeMonsterDataSource.dummyMonster.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}