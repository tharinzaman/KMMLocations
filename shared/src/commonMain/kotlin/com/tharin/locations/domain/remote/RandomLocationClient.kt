package com.tharin.locations.domain.remote

import com.tharin.locations.domain.model.LocationItem

interface RandomLocationClient {
    suspend fun getRandomLocation(): LocationItem
}