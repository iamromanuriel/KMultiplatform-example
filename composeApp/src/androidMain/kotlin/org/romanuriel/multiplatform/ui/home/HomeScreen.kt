package org.romanuriel.multiplatform.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.romanuriel.multiplatform.ui.component.Element
import org.romanuriel.multiplatform.ui.component.TopBarMain
import org.romanuriel.multiplatform.ui.component.elementList

@Composable
fun HomeScreen(){
    val list = elementList
    Scaffold(
        topBar = { TopBarMain() }
    ) { containerPadding ->
        LazyColumn(contentPadding = containerPadding) {
            items(list) { elementModel ->
                Element(onClick = {  }, elementModel = elementModel )
            }
        }
    }
}
@Composable
@Preview
fun HomeScreenPreview(){
    val list = elementList
    Scaffold(
        topBar = { TopBarMain() }
    ) { containerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(1.dp),
            contentPadding = containerPadding,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(list) { elementModel ->
                Element(onClick = {  }, elementModel = elementModel )
            }
        }
    }
}