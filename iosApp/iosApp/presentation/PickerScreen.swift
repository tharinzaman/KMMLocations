//
//  PickerScreen.swift
//  iosApp
//
//  Created by Tharin Zaman on 16/11/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PickerScreen: View {
    
    let component: PickerComponent
    
    init(
        component: PickerComponent
    ) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Button(
                action: {
                    component
                        .onNavigateToMap()
                }
            )
            {
                Text("Go to Map")
            }
            Button(
                action: {
                    component
                        .onNavigateToHistory()
                }
            )
            {
                Text("Go to History")
            }
        }
    }
}

