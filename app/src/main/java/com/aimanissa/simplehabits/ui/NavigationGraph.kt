package com.aimanissa.simplehabits.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aimanissa.common.find
import com.aimanissa.feature_new_habit.navigation.api.NewHabitEntry
import com.aimanissa.home_feature.navigation.api.HomeEntry
import com.aimanissa.simplehabits.di.LocalAppDependencies

@Composable
fun NavigationGraph(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    val destinations = LocalAppDependencies.current.destinations

    val homeScreen = destinations.find<HomeEntry>()
    val newHabitScreen = destinations.find<NewHabitEntry>()

    Box(Modifier.padding(paddingValues)) {
        NavHost(navController, startDestination = homeScreen.destination()) {
            with(homeScreen) {
                composable(navController, destinations)
            }
            with(newHabitScreen) {
                composable(navController, destinations)
            }
        }
    }
}