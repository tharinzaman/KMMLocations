package com.tharin.locations.android.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tharin.locations.android.presentation.components.PreviousRandomLocationsTable
import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.presentation.states.HistoryScreenState

@Composable
fun HistoryScreen(
    historyScreenState: State<HistoryScreenState>,
    onAppear: () -> Unit,
    onDelete: (LocationItem) -> Unit
) {

    LaunchedEffect(key1 = null) {
        onAppear()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(historyScreenState.value) {
            HistoryScreenState.FailedToLoad -> {
                Text(text = "Error loading previous random locations")
            }
            is HistoryScreenState.Loaded -> {
                PreviousRandomLocationsTable(
                    locations = (historyScreenState.value as HistoryScreenState.Loaded).previousRandomLocations,
                    onDelete = onDelete
                )
            }
            HistoryScreenState.Loading -> {
                // TODO: Replace with loading icon
                Text(text = "Loading")
            }
            HistoryScreenState.NoPreviousRandomLocations -> {
                Text(text = "No previous random locations")
            }

        }
    }

}