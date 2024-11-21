package com.tharin.locations

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform