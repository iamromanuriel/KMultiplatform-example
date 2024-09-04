package org.romanuriel.multiplatform.network.util


object NetworkUtil {

    enum class Route(val value: String){
        CHARACTERS("character"),
        LOCATION("location"),
        EPISODE("episode")
    }
    const val baseUrl = "https://rickandmortyapi.com/api/"

    fun buildUrl(route: Route, urlBase: String? = baseUrl): String{
        return baseUrl + route.value
    }
}