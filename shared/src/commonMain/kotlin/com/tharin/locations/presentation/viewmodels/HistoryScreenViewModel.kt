package com.tharin.locations.presentation.viewmodels

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.usecases.local.DeleteLocationDatabaseItemByIdUseCase
import com.tharin.locations.domain.usecases.local.GetAllLocationDatabaseItemsUseCase
import com.tharin.locations.domain.utils.toCommonStateFlow
import com.tharin.locations.presentation.events.HistoryScreenEvent
import com.tharin.locations.presentation.states.HistoryScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

class HistoryScreenViewModel(
    private val getAllLocationDatabaseItemsUseCase: GetAllLocationDatabaseItemsUseCase,
    private val deleteLocationDatabaseItemByIdUseCase: DeleteLocationDatabaseItemByIdUseCase,
    private val coroutineScope: CoroutineScope,
) {

    private val viewModelScope = coroutineScope

    private val _historyScreenState: MutableStateFlow<HistoryScreenState> =
        MutableStateFlow(HistoryScreenState.Loading)
    val historyScreenState: StateFlow<HistoryScreenState> = _historyScreenState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        HistoryScreenState.Loading
    ).toCommonStateFlow()

    fun onEvent(event: HistoryScreenEvent) {
        when (event) {
            is HistoryScreenEvent.DeleteLocationItem -> deleteLocation(item = event.item)
        }
    }

    fun fetchAllPreviousRandomLocations() {
        try {
            viewModelScope.launch {
                getAllLocationDatabaseItemsUseCase(
                    viewModelScope.coroutineContext
                ).map { previousRandomLocations ->
                    _historyScreenState.update {
                        if (previousRandomLocations.isEmpty()) {
                            HistoryScreenState.NoPreviousRandomLocations
                        } else {
                            HistoryScreenState.Loaded(previousRandomLocations)
                        }
                    }
                }.collect()
            }
        } catch (e: Exception) {
            _historyScreenState.update {
                HistoryScreenState.FailedToLoad
            }
        }
    }

    private fun deleteLocation(item: LocationItem) {
        coroutineScope.launch {
            item.id?.let { id ->
                deleteLocationDatabaseItemByIdUseCase(id)
            }
        }
    }
}