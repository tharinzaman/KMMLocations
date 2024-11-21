//
//  HistoryScreen.swift
//  iosApp
//
//  Created by Tharin Zaman on 16/11/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HistoryScreen: View {
    
    let component: HistoryComponent
    
    init(
        component: HistoryComponent
    ) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Text("Thsi is the History Screen")
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

