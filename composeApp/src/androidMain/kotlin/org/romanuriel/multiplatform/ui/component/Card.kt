package org.romanuriel.multiplatform.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.romanuriel.multiplatform.R

@SuppressLint("Range")
@Composable
fun CardCarMain(
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier.fillMaxWidth()
    ) {
        Row(){
            Text(text = "120,000 km")
        }
    }
}

@Preview
@Composable
fun CardCarMainPreview(){
    CardCarMain()
}