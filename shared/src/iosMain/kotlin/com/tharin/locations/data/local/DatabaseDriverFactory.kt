package com.tharin.locations.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.tharin.locations.database.LocationsDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            LocationsDatabase.Schema,
            "locations.db"
        )
    }
}