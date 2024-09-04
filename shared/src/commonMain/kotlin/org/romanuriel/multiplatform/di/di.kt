package org.romanuriel.multiplatform.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.romanuriel.multiplatform.network.util.NetworkClient
import org.romanuriel.multiplatform.network.util.NetworkUtil
import org.romanuriel.multiplatform.repository.CharacterRepository

val dataModule = module {
    single {
        HttpClient{
            install(ContentNegotiation){
                json(Json{
                    ignoreUnknownKeys = true
                })
            }
            install(DefaultRequest){
                url{
                    protocol = URLProtocol.HTTPS
                    host = NetworkUtil.baseUrl
                }
            }
        }
    }
}

val networkClientModule = module {
    singleOf(::NetworkClient)
}

val repositoryModule = module {
    singleOf(::CharacterRepository)
}