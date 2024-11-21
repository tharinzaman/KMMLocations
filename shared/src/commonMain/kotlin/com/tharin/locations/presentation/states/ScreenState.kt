package com.tharin.locations.presentation.states

import com.tharin.locations.domain.model.LocationType

sealed interface ScreenState {
    data object FirstScreen: ScreenState
    data class MapScreen(val locationType: LocationType): ScreenState
    data object HistoryScreen: ScreenState
}