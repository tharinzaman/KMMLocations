package com.tharin.locations.data.di

import com.squareup.sqldelight.db.SqlDriver
import com.tharin.locations.data.local.DatabaseDriverFactory
import com.tharin.locations.data.local.LocationsDataSourceImpl
import com.tharin.locations.data.remote.RandomLocationClientImpl
import com.tharin.locations.database.LocationsDatabase
import com.tharin.locations.domain.local.LocationsDataSource
import com.tharin.locations.domain.remote.RandomLocationClient
import org.koin.core.module.Module
import org.koin.dsl.module

internal val commonSharedDataModule = module {

    single { LocationsDatabase(get<SqlDriver>()) }
    single<LocationsDataSource> { LocationsDataSourceImpl(get()) }

    single<RandomLocationClient> { RandomLocationClientImpl(get()) }
}

val commonDataModule: Module get() = module {
    includes(commonSharedDataModule + platformDataModule)
}

internal expect val platformDataModule: Module