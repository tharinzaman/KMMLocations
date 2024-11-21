package com.tharin.locations.data.mappers

import com.benasher44.uuid.uuid4
import com.tharin.locations.data.remote.RandomLocationModel
import com.tharin.locations.data.utils.generateRandomUniqueId
import com.tharin.locations.domain.model.LocationItem
import database.LocationEntity
import kotlinx.datetime.Clock

fun List<LocationEntity>.toLocationDatabaseItemsList(): List<LocationItem> =
    this.map { locationEntity ->
        locationEntity.toLocationDatabaseItem()
    }

fun LocationEntity.toLocationDatabaseItem(): LocationItem =
    LocationItem(
        id = this.id,
        name = this.name,
        latitude = this.latitude,
        longitude = this.longitude
    )

fun RandomLocationModel.toLocationItem(): LocationItem =
    LocationItem(
        id = generateRandomUniqueId(),
        name = this.name,
        latitude = this.lat,
        longitude = this.long
    )