package com.syizuril.risemonsterdex.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syizuril.risemonsterdex.ui.viewmodel.MonsterDexViewModel
import com.syizuril.risemonsterdex.R
import com.syizuril.risemonsterdex.ui.viewmodel.ViewModelFactory
import com.syizuril.risemonsterdex.data.MonsterRepository
import com.syizuril.risemonsterdex.ui.components.home.MonsterItem
import com.syizuril.risemonsterdex.ui.components.home.SearchBar

/**
 * Created by Syekh Syihabuddin Azmil Umri on 26/12/2022.
 */
@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MonsterDexViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(
            MonsterRepository()
        )
    ),
) {
    val groupedMonster by viewModel.groupedMonster.collectAsState()
    val query by viewModel.query
    val systemUiController = rememberSystemUiController()
    val color = MaterialTheme.colors.background
    DisposableEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = color
        )
        onDispose {}
    }
    Box(modifier = modifier) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            modifier = Modifier
                .testTag("MonsterList")
        ) {
            item {
                Column(modifier = Modifier.padding(8.dp)){
                    AppName(modifier = Modifier.padding(8.dp), navController = navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    SearchBar(
                        query = query,
                        onQueryChange = viewModel::search,
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                    )
                }

            }
            groupedMonster.forEach { (_, monsters) ->
                items(monsters, key = { it.name }) { monster ->
                    MonsterItem(
                        monster,
                        onItemClicked = {
                            navController.navigate("details/${it.name}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AppName(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {navController.navigate("about") },
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "about_page",
                    tint = MaterialTheme.colors.surface
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.app_desc),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.surface
        )
    }
}