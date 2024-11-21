package com.tharin.locations.domain.usecases.local

import com.tharin.locations.domain.local.LocationsDataSource

class DeleteLocationDatabaseItemByIdUseCase(
    private val locationsDataSource: LocationsDataSource
) {

    suspend operator fun invoke(
        id: Long
    ) = locationsDataSource.deleteLocationDatabaseItemById(id = id)

}