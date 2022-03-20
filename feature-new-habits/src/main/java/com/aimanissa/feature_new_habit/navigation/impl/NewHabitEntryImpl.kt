package com.aimanissa.feature_new_habit.navigation.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.aimanissa.common.Destinations
import com.aimanissa.common.di.LocalCommonDependencies
import com.aimanissa.common.di.injectedViewModel
import com.aimanissa.data.di.LocalDataDependencies
import com.aimanissa.feature_new_habit.di.DaggerNewHabitComponent
import com.aimanissa.feature_new_habit.navigation.api.NewHabitEntry
import com.aimanissa.feature_new_habit.ui.NewHabitsScreen
import javax.inject.Inject

class NewHabitEntryImpl @Inject constructor() : NewHabitEntry() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val viewModel = injectedViewModel {
            DaggerNewHabitComponent.builder()
                .commonDependencies(LocalCommonDependencies.current)
                .dataDependencies(LocalDataDependencies.current)
                .build()
                .viewModel
        }
        NewHabitsScreen(navController, viewModel)
    }
}
