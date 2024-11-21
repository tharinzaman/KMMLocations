package com.tharin.locations.domain.usecases.local

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.local.LocationsDataSource
import com.tharin.locations.domain.utils.CommonFlow
import kotlin.coroutines.CoroutineContext

class GetLocationDatabaseItemByIdUseCase(
    private val locationsDataSource: LocationsDataSource
) {

    operator fun invoke(
        id: Long,
        context: CoroutineContext
    ): CommonFlow<LocationItem> =
        locationsDataSource.getLocationDatabaseItemById(
            id = id,
            context = context
        )
}