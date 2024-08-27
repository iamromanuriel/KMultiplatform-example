package org.romanuriel.multiplatform.ui.component



//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMain(
    modifier: Modifier = Modifier,
    title: String? = null,
){
    TopAppBar(
        title = { Text(text = "Hola Matilda") },
        actions = {
            CompositionLocalProvider(value = LocalContentAlpha.provides(ContentAlpha.high)) {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null )
                }

                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = null)
                }
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview(){
    TopBarMain()
}