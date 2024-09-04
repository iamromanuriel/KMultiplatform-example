package org.romanuriel.multiplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.romanuriel.multiplatform.ui.nav.Navigation
import org.romanuriel.multiplatform.ui.screen.character.CharacterScreen
import org.romanuriel.multiplatform.ui.screen.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Navigation()
        }
    }
}

