package com.tharin.locations.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tharin.locations.android.presentation.screens.HistoryScreen
import com.tharin.locations.android.presentation.screens.MapScreen
import com.tharin.locations.android.presentation.screens.PickerScreen
import com.tharin.locations.android.presentation.viewmodels.AndroidHistoryScreenViewModel
import com.tharin.locations.android.presentation.viewmodels.AndroidMapScreenViewModel
import com.tharin.locations.domain.model.LocationType
import com.tharin.locations.presentation.events.HistoryScreenEvent

@Composable
fun NavigationComposable(
    mapScreenVM: AndroidMapScreenViewModel,
    historyScreenVM: AndroidHistoryScreenViewModel
) {

    val navController = rememberNavController()

    val locationState = mapScreenVM.locationState.collectAsStateWithLifecycle()
    val historyScreenState = historyScreenVM.historyScreenState.collectAsStateWithLifecycle()

    NavHost(navController = navController, startDestination = Routes.PICKER) {
        composable(Routes.PICKER) {
            PickerScreen(
                onUserLocationClicked = {
                    navController.navigate("${Routes.MAP}/${LocationType.USER}")
                },
                onRandomLocationClicked = {
                    navController.navigate("${Routes.MAP}/${LocationType.RANDOM}")
                },
                onHistoryClicked = {
                    navController.navigate(Routes.HISTORY)
                }
            )
        }
        composable("${Routes.MAP}/{locationType}") { backStackEntry ->
            val locationType =
                backStackEntry.arguments?.getString("locationType", LocationType.RANDOM.name)
            MapScreen(
                locationState = locationState,
                onAppear = {
                    mapScreenVM.fetchLocation(
                        if (locationType == LocationType.USER.name) LocationType.USER else LocationType.RANDOM
                    )
                }
            )
        }
        composable(Routes.HISTORY) {
            HistoryScreen(
                historyScreenState = historyScreenState,
                onAppear = { historyScreenVM.fetchAllPreviousRandomLocations() },
                onDelete = {
                    historyScreenVM.onEvent(HistoryScreenEvent.DeleteLocationItem(it))
                }
            )
        }
    }
}
