package com.tharin.locations.data.di

import com.tharin.locations.data.local.DatabaseDriverFactory
import com.tharin.locations.data.remote.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformDataModule: Module = module {
    single { DatabaseDriverFactory().create() }
    single<HttpClient> { HttpClientFactory().create() }
}