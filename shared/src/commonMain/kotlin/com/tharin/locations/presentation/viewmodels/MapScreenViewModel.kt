package com.tharin.locations.presentation.viewmodels

import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.model.LocationType
import com.tharin.locations.domain.usecases.remote.FetchRandomLocationUseCase
import com.tharin.locations.presentation.states.LocationState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MapScreenViewModel(
    private val coroutineScope: CoroutineScope,
    private val fetchRandomLocationUseCase: FetchRandomLocationUseCase,
    // TODO(Add in a use case to get the user location)
) {

    private val viewModelScope = coroutineScope

    private val _locationState: MutableStateFlow<LocationState> =
        MutableStateFlow(LocationState.Loading)
    val locationState = _locationState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        LocationState.Loading
    )

    fun fetchLocation(type: LocationType) {
        _locationState.update { LocationState.Loading }
        when (type) {
            LocationType.RANDOM -> {
                viewModelScope.launch {
                    try {
                        val randomLocation = fetchRandomLocationUseCase()
                        _locationState.update { LocationState.Loaded(randomLocation) }
                    } catch (e: Exception) {
                        _locationState.update { LocationState.FailedToLoad }
                    }
                }

            }
            LocationType.USER -> {
                println("Getting User Location")
            }
        }
    }
}