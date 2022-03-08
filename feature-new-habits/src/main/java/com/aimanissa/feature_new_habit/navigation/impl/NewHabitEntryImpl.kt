package com.aimanissa.feature_new_habit.navigation.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.aimanissa.common.Destinations
import com.aimanissa.feature_new_habit.navigation.api.NewHabitEntry
import javax.inject.Inject

class NewHabitEntryImpl @Inject constructor() : NewHabitEntry() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        TODO("Not yet implemented")
    }
}
