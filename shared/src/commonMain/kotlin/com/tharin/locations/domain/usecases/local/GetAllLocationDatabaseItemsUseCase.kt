package com.tharin.locations.domain.usecases.local

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.local.LocationsDataSource
import com.tharin.locations.domain.utils.CommonFlow
import kotlin.coroutines.CoroutineContext

class GetAllLocationDatabaseItemsUseCase(
    private val locationsDataSource: LocationsDataSource
) {

    operator fun invoke(
        context: CoroutineContext
    ): CommonFlow<List<LocationItem>> {
        val items = locationsDataSource.getAllLocationDatabaseItems(
            context = context
        )
        return items
    }
}