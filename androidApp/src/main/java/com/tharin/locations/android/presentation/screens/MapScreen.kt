package com.tharin.locations.android.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tharin.locations.presentation.states.LocationState

@Composable
fun MapScreen(
    locationState: State<LocationState>,
    onAppear: () -> Unit
) {

    LaunchedEffect(key1 = false) {
        onAppear()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Current state is: ${locationState.value}")
    }

}