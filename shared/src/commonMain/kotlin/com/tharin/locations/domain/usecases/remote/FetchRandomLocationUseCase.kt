package com.tharin.locations.domain.usecases.remote

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.remote.RandomLocationClient
import com.tharin.locations.domain.usecases.local.InsertLocationDatabaseItemUseCase

class FetchRandomLocationUseCase(
    private val randomLocationClient: RandomLocationClient,
    private val insertLocationDatabaseItemUseCase: InsertLocationDatabaseItemUseCase
) {

    suspend operator fun invoke(): LocationItem {
        try {
            val randomLocation = randomLocationClient.getRandomLocation()
            insertLocationDatabaseItemUseCase(
                item = randomLocation
            )
            return randomLocation
        } catch (e: Exception) {
            throw e
        }
    }

}