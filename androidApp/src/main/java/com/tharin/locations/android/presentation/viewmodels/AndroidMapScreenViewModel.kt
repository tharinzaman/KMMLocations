package com.tharin.locations.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tharin.locations.domain.model.LocationType
import com.tharin.locations.domain.usecases.remote.FetchRandomLocationUseCase
import com.tharin.locations.presentation.viewmodels.MapScreenViewModel

class AndroidMapScreenViewModel(
    private val fetchRandomLocationUseCase: FetchRandomLocationUseCase
): ViewModel() {

    private val viewModel by lazy {
        MapScreenViewModel(
            fetchRandomLocationUseCase = fetchRandomLocationUseCase,
            coroutineScope = viewModelScope
        )
    }

    val locationState = viewModel.locationState

    fun fetchLocation(type: LocationType) {
        viewModel.fetchLocation(type)
    }
}