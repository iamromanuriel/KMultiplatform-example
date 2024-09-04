package org.romanuriel.multiplatform.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.network.util.NetworkClient

class CharacterRepository(private val networkClient : NetworkClient) {

    suspend fun getListCharacter(): List<Character>{
        return withContext(Dispatchers.IO) {
            networkClient.getListCharacter().characters
        }
    }

    suspend fun getCharacterId(id: Int = 0): Character{
        return withContext(Dispatchers.IO){
            networkClient.getCharacterById(id)
        }
    }
}