package com.syizuril.risemonsterdex.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syizuril.risemonsterdex.data.MonsterRepository
import com.syizuril.risemonsterdex.model.Monster

/**
 * Created by Syekh Syihabuddin Azmil Umri on 19/12/2022.
 */
class MonsterDetailViewModel(private val repository: MonsterRepository): ViewModel() {
    fun getMonsterByName(name: String): Monster {
        return repository.getMonsterByName(name)
    }
}

class MonsterDetailViewModelFactory(private val repository: MonsterRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonsterDetailViewModel::class.java)) {
            return MonsterDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}