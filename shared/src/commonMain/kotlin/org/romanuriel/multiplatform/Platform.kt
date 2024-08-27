package org.romanuriel.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform