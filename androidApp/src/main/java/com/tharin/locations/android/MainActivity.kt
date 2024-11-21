package com.tharin.locations.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tharin.locations.android.presentation.navigation.NavigationComposable
import com.tharin.locations.android.presentation.viewmodels.AndroidHistoryScreenViewModel
import com.tharin.locations.android.presentation.viewmodels.AndroidMapScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapScreenVM: AndroidMapScreenViewModel by viewModel()
        val historyScreenVM: AndroidHistoryScreenViewModel by viewModel()

        setContent {
//            val state = vm.locationState.collectAsStateWithLifecycle()
//            vm.fetchLocation(LocationType.RANDOM)
//            Log.d("MapScreenViewModel", "State is ${vm.locationState.value}")
//            if (vm.locationState.value is LocationState.Loaded) {
//                Log.d("MapScreenViewModel", "Location is ${(vm.locationState.value as LocationState.Loaded).locationItem}")
//            } else {
//                Log.d("MapScreenViewModel", "Location is not loaded")
//            }
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//                        Text(text = "State is: $state")
//                        if(state.value is LocationState.Loaded) {
//                            Text(text = "Location is ${(state.value as LocationState.Loaded).locationItem}")
//                        } else {
//                            Text(text = "No location yet found")
//                        }
//                    }
//                }
//            }
            MyApplicationTheme {
                NavigationComposable(
                    mapScreenVM = mapScreenVM,
                    historyScreenVM = historyScreenVM
                )
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
