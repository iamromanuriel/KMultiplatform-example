package org.romanuriel.multiplatform.network.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseNetwork(
    val info: Info,
    @SerialName("results")
    val characters: List<Character>
)