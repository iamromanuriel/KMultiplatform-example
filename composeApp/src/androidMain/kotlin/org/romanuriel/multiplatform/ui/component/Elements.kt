package org.romanuriel.multiplatform.ui.component

import android.graphics.Paint.Style
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material.ListItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val elementList = listOf(
    ElementModel(id = 1, title = "Tarea 1", description = "Completar informe", date = "2023-11-28"),
    ElementModel(id = 2, title = "Reunión", description = "Discutir proyecto", date = "2023-12-02"),
    ElementModel(id = 3, title = "Presentación", description = "Preparar diapositivas", date = "2023-12-05")
)

class ElementModel(
    var id: Int = 0,
    var title: String = "",
    var description : String = "",
    var date: String = ""
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Element(
    onClick: () -> Unit,
    elementModel: ElementModel,
    modifier: Modifier = Modifier
){
    ListItem(
        modifier = modifier.clickable(enabled = true, onClick = onClick),
        icon = {
            IndicatorItem(text = elementModel.title)
        },
        text = {
            Column {
                Text(text = elementModel.title)
                Text(text = elementModel.description, fontSize = 12.sp)
            }
        },
        trailing = {
            Text(text = elementModel.date)
        }
    )
}

@Composable
fun IndicatorItem(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes draw: Int ?= null
){
    Box(
        modifier = modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(Color.LightGray)

    ){
        if (draw != null) {
            Icon(
                painter = painterResource(id = draw),
                contentDescription = null,
                modifier = modifier.fillMaxSize()
            )
        } else {
            Text(
                text = text?.getOrNull(0)?.toString() ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}

@Preview(name = "Basic", showBackground = true)
@Composable
fun ElementPreview(){
    Element(onClick = {  }, elementModel = ElementModel(title = "Mantenimiento preventivo", description = "Mantenimiento despuesde ...", date = "12/12/23"))
}
