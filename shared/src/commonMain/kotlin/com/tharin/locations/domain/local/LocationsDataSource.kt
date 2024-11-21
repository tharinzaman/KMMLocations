package com.tharin.locations.domain.local

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.utils.CommonFlow
import kotlin.coroutines.CoroutineContext

interface LocationsDataSource {
    suspend fun insertLocationDatabaseItem(
        item: LocationItem
    )
    suspend fun deleteLocationDatabaseItemById(
        id: Long
    )
    fun getLocationDatabaseItemById(
        id: Long,
        context: CoroutineContext
    ): CommonFlow<LocationItem>
    fun getAllLocationDatabaseItems(
        context: CoroutineContext
    ): CommonFlow<List<LocationItem>>
}