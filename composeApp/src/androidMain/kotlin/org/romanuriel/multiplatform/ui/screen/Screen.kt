package org.romanuriel.multiplatform.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Screen(content: @Composable () -> Unit){
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}