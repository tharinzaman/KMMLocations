package com.tharin.locations.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("nearest")
    val randomLocation: RandomLocationModel
)

@Serializable
data class RandomLocationModel(
    val name: String,
    @SerialName("latt")
    val lat: String,
    @SerialName("longt")
    val long: String
)
