package com.tharin.locations.data.local

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import com.tharin.locations.data.mappers.toLocationDatabaseItem
import com.tharin.locations.data.mappers.toLocationDatabaseItemsList
import com.tharin.locations.database.LocationsDatabase
import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.local.LocationsDataSource
import com.tharin.locations.domain.utils.CommonFlow
import com.tharin.locations.domain.utils.toCommonFlow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.CoroutineContext

class LocationsDataSourceImpl(
    db: LocationsDatabase
): LocationsDataSource {

    private val queries = db.locationsDatabaseQueries

    override suspend fun insertLocationDatabaseItem(item: LocationItem) =
        queries.insertLocation(
            id = item.id,
            name = item.name,
            latitude = item.latitude,
            longitude = item.latitude
        )

    override suspend fun deleteLocationDatabaseItemById(id: Long) =
        queries.deleteLocationById(
            id = id
        )

    override fun getLocationDatabaseItemById(
        id: Long,
        context: CoroutineContext
    ): CommonFlow<LocationItem> =
        queries
            .getLocationById(
                id = id
            )
            .asFlow()
            .mapToOne(context)
            .map {
                it.toLocationDatabaseItem()
            }
            .toCommonFlow()

    override fun getAllLocationDatabaseItems(context: CoroutineContext): CommonFlow<List<LocationItem>> {
        val history = queries
            .getAllLocations()
            .asFlow()
            .mapToList(context)
            .map { location ->
                location.toLocationDatabaseItemsList()
            }
        return history.toCommonFlow()
    }

}