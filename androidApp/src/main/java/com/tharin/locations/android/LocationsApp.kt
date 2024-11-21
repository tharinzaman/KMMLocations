package com.tharin.locations.android

import android.app.Application
import com.tharin.locations.android.di.androidModule
import com.tharin.locations.data.di.commonDataModule
import com.tharin.locations.domain.di.commonDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LocationsApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LocationsApp)
            modules(commonDataModule, commonDomainModule, androidModule)
        }
    }
}