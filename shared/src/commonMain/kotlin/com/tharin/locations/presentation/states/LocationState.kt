package com.tharin.locations.presentation.states

import com.tharin.locations.domain.model.LocationItem

sealed interface LocationState {
    data object Loading: LocationState
    data class Loaded(val locationItem: LocationItem): LocationState
    data object FailedToLoad: LocationState
}