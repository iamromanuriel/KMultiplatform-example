package org.romanuriel.multiplatform.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.ui.screen.Screen
import org.romanuriel.multiplatform.ui.component.Element
import org.romanuriel.multiplatform.ui.component.TopBarMain
import org.romanuriel.multiplatform.ui.nav.Home

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    onClickCharacter: (Character) -> Unit,
    vm: HomeViewModel = koinViewModel()
){
    Screen{
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold (
            topBar =  { TopBarMain(scrollBehavior = scrollBehavior) },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ){ contentPadding ->
            Column {
                val state = vm.state
                Log.d("getListCharacter", Json.encodeToString(state.characters))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(contentPadding)
                ) {
                    items(state.characters){ character ->
                        Element(onClick = { onClickCharacter(character) }, character = character)
                    }
                }
            }
        }
    }
}
