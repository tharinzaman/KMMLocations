package com.tharin.locations.presentation.events

import com.tharin.locations.domain.model.LocationItem

sealed interface HistoryScreenEvent {
    data class DeleteLocationItem(val item: LocationItem): HistoryScreenEvent
}