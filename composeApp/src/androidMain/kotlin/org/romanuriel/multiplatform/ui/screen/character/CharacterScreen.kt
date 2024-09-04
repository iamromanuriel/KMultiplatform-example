package org.romanuriel.multiplatform.ui.screen.character

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf
import org.romanuriel.multiplatform.R
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.ui.component.CardCarMain
import org.romanuriel.multiplatform.ui.component.TopBarBasic

val character1 = Character(created = "12", gender = "", id = 1, image = "", name = "Roman", species = "", type = "", status = "", url = "")
@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    popBack: () -> Unit,
    id: Int,
    vm: CharacterViewModel = koinViewModel{ parametersOf(id) }
){
    val state = vm.state
    Scaffold(
        modifier = modifier.fillMaxWidth(),
        topBar = { TopBarBasic(title = state.character?.name) { popBack() } }
    ) { contentPadding ->
        state.character?.let {
            CardCarMain(
                character = it,
                modifier = modifier.padding(contentPadding)
            )
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CharacterDetail(
    character: Character,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.padding(16.dp)
    ) {
        val maxImageSize = this.maxWidth / 2
        val imageSize = min(maxImageSize, 148.dp)
        Column {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = modifier.fillMaxWidth()
            ) {
                //AsyncImage(model = character.image, contentDescription = null)
                Box(modifier = modifier.size(60.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null
                    )
                }
                Column(
                    modifier = modifier.padding(start = 16.dp)
                ) {
                    Text(text = character.species)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CharacterDetailPreview(){
    CharacterDetail(character = character1)
}

@Composable
@Preview
fun CharacterScreenPreview(){

}
