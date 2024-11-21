package com.tharin.locations.android.di

import com.tharin.locations.android.presentation.viewmodels.AndroidHistoryScreenViewModel
import com.tharin.locations.android.presentation.viewmodels.AndroidMapScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { AndroidMapScreenViewModel(get()) }
    viewModel { AndroidHistoryScreenViewModel(get(), get()) }
}