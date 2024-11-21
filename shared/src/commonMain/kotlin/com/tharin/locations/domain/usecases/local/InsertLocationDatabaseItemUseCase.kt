package com.tharin.locations.domain.usecases.local

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.local.LocationsDataSource

class InsertLocationDatabaseItemUseCase(
    private val locationsDataSource: LocationsDataSource
) {

    suspend operator fun invoke(item: LocationItem) =
        locationsDataSource.insertLocationDatabaseItem(item = item)
}