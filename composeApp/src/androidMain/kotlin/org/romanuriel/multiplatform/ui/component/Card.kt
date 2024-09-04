package org.romanuriel.multiplatform.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import coil3.compose.AsyncImage
import org.romanuriel.multiplatform.R
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.ui.screen.character.character1
import kotlin.math.min

@SuppressLint("Range")
@Composable
fun CardCarMain(
    modifier: Modifier = Modifier,
    character: Character
){
    Card (
        modifier = modifier.fillMaxWidth()
    ) {
        BoxWithConstraints(modifier = modifier.padding(16.dp)) {
            val maxImageSize = this.maxWidth / 2
            val imageSize = min(maxImageSize, 148.dp)
            Column {
                Row(
                    modifier = modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = modifier.padding(8.dp).size(60.dp)
                    ) {
                        AsyncImage(model = character.image , contentDescription = null)
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                            contentDescription = null
//                        )
                    }
                    Column(
                        modifier = modifier,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = character.species)
                        Text(text = character.status)
                        Text(text = character.gender)
                        Text(text = character.created)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CardCarMainPreview(){
    CardCarMain(character = character1)
}