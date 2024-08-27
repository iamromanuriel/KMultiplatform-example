package org.romanuriel.multiplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.romanuriel.multiplatform.ui.component.Element
import org.romanuriel.multiplatform.ui.component.ElementModel
import org.romanuriel.multiplatform.ui.component.TopBarMain
import org.romanuriel.multiplatform.ui.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

}