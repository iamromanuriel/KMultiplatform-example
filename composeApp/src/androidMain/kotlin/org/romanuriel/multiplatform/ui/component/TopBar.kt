package org.romanuriel.multiplatform.ui.component

//noinspection UsingMaterialAndMaterial3Libraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.romanuriel.multiplatform.R
import org.romanuriel.multiplatform.util.appBarBasic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMain(
    modifier: Modifier = Modifier,
    title: String? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = { Text(text = title?:stringResource(id = R.string.app_name))},
        actions = {
            CompositionLocalProvider(value = LocalContentAlpha.provides(ContentAlpha.high)) {
                IconButton(onClick = { }) {
                    Box(modifier = modifier.size(100.dp), contentAlignment = Alignment.Center){
                        BadgedBox(badge ={
                            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)
                        } ) {
                            Box(modifier = modifier
                                .size(5.dp)
                                .clip(CircleShape)
                                .background(Color.Red))
                        }
                    }
                }

                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = null)
                }
            }
        },
        colors = appBarBasic(),
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBasic(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBack: () -> Unit
){
    TopAppBar(
        title = { Text(text = title?:"") },
        modifier,
        navigationIcon = { IconButton(onClick = { onBack() }) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        } }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBarPreview(){
    TopBarMain()
}
@Composable
@Preview
fun TopBarBasicPreview(){
    TopBarBasic(title = "Character") {

    }
}