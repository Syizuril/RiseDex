package com.syizuril.risemonsterdex.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syizuril.risemonsterdex.data.MonsterRepository
import com.syizuril.risemonsterdex.model.Monster
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Syekh Syihabuddin Azmil Umri on 19/12/2022.
 */
class MonsterDexViewModel(private val repository: MonsterRepository): ViewModel() {
    private val _groupedMonster = MutableStateFlow(
        repository.getMonster()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    val groupedMonster: StateFlow<Map<Char, List<Monster>>> get() = _groupedMonster

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedMonster.value = repository.searchMonster(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}

class ViewModelFactory(private val repository: MonsterRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonsterDexViewModel::class.java)) {
            return MonsterDexViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}