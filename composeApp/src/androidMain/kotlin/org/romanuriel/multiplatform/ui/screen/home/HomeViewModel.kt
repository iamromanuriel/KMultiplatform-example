package org.romanuriel.multiplatform.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.repository.CharacterRepository

class HomeViewModel(characterRepository: CharacterRepository): ViewModel() {

    var state by mutableStateOf(UIState())
        private set

    init {
        viewModelScope.launch {
            state = UIState(loading = true)
            state = UIState(loading = false, characters = characterRepository.getListCharacter())
        }
    }

    data class UIState(
        val loading: Boolean = false,
        val characters: List<Character> = emptyList()
    )
}