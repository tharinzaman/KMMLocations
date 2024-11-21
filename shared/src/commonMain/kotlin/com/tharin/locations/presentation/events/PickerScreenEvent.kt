package com.tharin.locations.presentation.events

import com.tharin.locations.domain.model.LocationType

sealed interface PickerScreenEvent {
    data class NavigateToMapPickerScreen(val locationType: LocationType): PickerScreenEvent
    data object NavigateToHistoryPickerScreen: PickerScreenEvent
}