package org.romanuriel.multiplatform.network.util

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.romanuriel.multiplatform.network.Model.Character
import org.romanuriel.multiplatform.network.Model.ResponseNetwork

class NetworkClient(
    private val httpClient: HttpClient
) {
    suspend fun getListCharacter(): ResponseNetwork{
        return httpClient.get(NetworkUtil.buildUrl(NetworkUtil.Route.CHARACTERS)){
            contentType(ContentType.Application.Json)
        }.body()
    }

    suspend fun getCharacterById(id: Int): Character{
        val url = NetworkUtil.buildUrl(NetworkUtil.Route.CHARACTERS) +"/"+ id.toString()
        println("UrlApi :: ${url}")
        return httpClient.get(url){
            contentType(ContentType.Application.Json)
        }.body()
    }
}