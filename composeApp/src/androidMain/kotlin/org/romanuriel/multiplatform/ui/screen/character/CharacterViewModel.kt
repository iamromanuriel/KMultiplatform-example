package org.romanuriel.multiplatform.ui.screen.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.repository.CharacterRepository

class CharacterViewModel(private val characterRepository: CharacterRepository, id: Int) : ViewModel() {
    var state by mutableStateOf(UIState())
    private set

    init {
        viewModelScope.launch {
            state = UIState(loading = true)
            state = UIState(loading = false, character = characterRepository.getCharacterId(id))
        }
    }

    data class UIState(
        val loading: Boolean = false,
        val character: Character? = null
    )
}