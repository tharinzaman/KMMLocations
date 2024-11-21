package com.tharin.locations.android.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tharin.locations.domain.model.LocationItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviousRandomLocationsTable(
    locations: List<LocationItem>,
    onDelete: (LocationItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                )
            )
    ) {
        stickyHeader {
            HeaderRow(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }
        items(locations) { location ->
            RandomLocationRow(
                location = location,
                onDelete = onDelete
            )
            HorizontalDivider(thickness = 0.5.dp, color = Color.Black)
        }
    }
}

@Composable
private fun HeaderRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier
    ) {
        TableText(
            text = "Name",
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            style = MaterialTheme.typography.titleSmall
        )
        TableText(
            text = "Latitude",
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            style = MaterialTheme.typography.titleSmall
        )
        TableText(
            text = "Longitude",
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RandomLocationRow(location: LocationItem, onDelete: (LocationItem) -> Unit) {
    val dismissState = rememberDismissState(DismissValue.Default)

    // This will trigger when the user swipes far enough to dismiss
    LaunchedEffect(dismissState.currentValue) {
        if (dismissState.currentValue == DismissValue.DismissedToStart) {
            onDelete(location)  // Call the onDelete callback
        }
    }

    // The SwipeToDismiss component that wraps the Row of each entry
    SwipeToDismiss(
        state = dismissState,
        modifier = Modifier.fillMaxWidth(),
        background = {},
        dismissContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                TableText(
                    text = location.name,
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                TableText(
                    text = location.latitude,
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                TableText(
                    text = location.longitude,
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    )
}

@Composable
private fun TableText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}
