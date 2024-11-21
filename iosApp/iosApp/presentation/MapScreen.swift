//
//  MapScreen.swift
//  iosApp
//
//  Created by Tharin Zaman on 16/11/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MapScreen: View {
    
    let component: MapComponent
    
    init(
        component: MapComponent
    ) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Text("Thsi is the Map Screen")
            Button(
                action: {
                    component
                        .onBackPressed()
                }
            )
            {
                Text("Back")
            }
        }
    }
}
