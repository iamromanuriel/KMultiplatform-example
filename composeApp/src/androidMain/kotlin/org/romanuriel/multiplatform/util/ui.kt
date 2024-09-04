package org.romanuriel.multiplatform.util

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
fun appBarBasic(): TopAppBarColors{
    return TopAppBarColors(
        containerColor = ColorApp.Purple,
        scrolledContainerColor = Color.White,
        navigationIconContentColor = Color.Black,
        titleContentColor = Color.Black,
        actionIconContentColor = Color.Black
    )
}

object ColorApp{
    val Purple = Color(0xFFE3D5FA)
    val Purple2 = Color(0xFF673AB7)
    val Green = Color(0xFF89CCC6)
    val Green2 = Color(0xFF337771)
    val Red = Color(0xFFD69595)
    val Red2 = Color(0xFF914040)
}