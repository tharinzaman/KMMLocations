package com.tharin.locations.presentation.states

import com.tharin.locations.domain.model.LocationItem

sealed interface HistoryScreenState {
    data object Loading: HistoryScreenState
    data class Loaded(val previousRandomLocations: List<LocationItem>): HistoryScreenState
    data object NoPreviousRandomLocations: HistoryScreenState
    data object FailedToLoad: HistoryScreenState
}