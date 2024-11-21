package com.tharin.locations.domain.di

import com.tharin.locations.domain.usecases.local.DeleteLocationDatabaseItemByIdUseCase
import com.tharin.locations.domain.usecases.local.GetAllLocationDatabaseItemsUseCase
import com.tharin.locations.domain.usecases.local.GetLocationDatabaseItemByIdUseCase
import com.tharin.locations.domain.usecases.local.InsertLocationDatabaseItemUseCase
import com.tharin.locations.domain.usecases.remote.FetchRandomLocationUseCase
import org.koin.dsl.module

val commonDomainModule = module {

    single { GetLocationDatabaseItemByIdUseCase(get()) }
    single { GetAllLocationDatabaseItemsUseCase(get()) }
    single { InsertLocationDatabaseItemUseCase(get()) }
    single { DeleteLocationDatabaseItemByIdUseCase(get()) }

    single { FetchRandomLocationUseCase(get(), get()) }
}