package org.romanuriel.multiplatform.ui.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.romanuriel.multiplatform.ui.screen.character.CharacterScreen
import org.romanuriel.multiplatform.ui.screen.home.HomeScreen

@Serializable
object Home
@Serializable
data class Character(val id: Int)

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> { backStackEntry ->
            HomeScreen (
                { navigateToCharacterDetail(backStackEntry){
                    navController.navigate(Character(it.id))
                } }
            )
        }
        composable<Character> { backStackEntry: NavBackStackEntry ->
            val character = backStackEntry.toRoute<Character>()
            CharacterScreen(popBack = { navController.popBackStack() }, id = character.id)
        }
    }
}

fun navigateToCharacterDetail(from: NavBackStackEntry, onNav: () -> Unit){
    if(from.lifecycle.currentState == Lifecycle.State.RESUMED){
        onNav()
    }
}