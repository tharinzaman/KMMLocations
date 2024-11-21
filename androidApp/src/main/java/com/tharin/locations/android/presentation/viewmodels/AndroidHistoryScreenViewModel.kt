package com.tharin.locations.android.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tharin.locations.domain.usecases.local.DeleteLocationDatabaseItemByIdUseCase
import com.tharin.locations.domain.usecases.local.GetAllLocationDatabaseItemsUseCase
import com.tharin.locations.presentation.events.HistoryScreenEvent
import com.tharin.locations.presentation.viewmodels.HistoryScreenViewModel

class AndroidHistoryScreenViewModel(
    private val getAllLocationDatabaseItemsUseCase: GetAllLocationDatabaseItemsUseCase,
    private val deleteLocationDatabaseItemByIdUseCase: DeleteLocationDatabaseItemByIdUseCase
): ViewModel() {

    private val viewModel by lazy {
        HistoryScreenViewModel(
            deleteLocationDatabaseItemByIdUseCase = deleteLocationDatabaseItemByIdUseCase,
            getAllLocationDatabaseItemsUseCase = getAllLocationDatabaseItemsUseCase,
            coroutineScope = viewModelScope
        )
    }

    val historyScreenState = viewModel.historyScreenState

    fun onEvent(event: HistoryScreenEvent) {
        viewModel.onEvent(event)
    }

    fun fetchAllPreviousRandomLocations() {
        viewModel.fetchAllPreviousRandomLocations()
    }

}