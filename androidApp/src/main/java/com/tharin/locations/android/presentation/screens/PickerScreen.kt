package com.tharin.locations.android.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PickerScreen(
    onUserLocationClicked: () -> Unit,
    onRandomLocationClicked: () -> Unit,
    onHistoryClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onUserLocationClicked) {
            Text("Current Location")
        }
        Button(onClick = onRandomLocationClicked) {
            Text("Random Location")
        }
        Button(onClick = onHistoryClicked) {
            Text("Previous Locations")
        }
    }
}