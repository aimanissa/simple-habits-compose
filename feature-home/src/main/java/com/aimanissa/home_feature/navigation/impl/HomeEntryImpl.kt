package com.aimanissa.home_feature.navigation.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.aimanissa.common.Destinations
import com.aimanissa.common.di.LocalCommonDependencies
import com.aimanissa.common.di.injectedViewModel
import com.aimanissa.data.di.LocalDataDependencies
import com.aimanissa.home_feature.di.DaggerHomeComponent
import com.aimanissa.home_feature.navigation.api.HomeEntry
import com.aimanissa.home_feature.ui.HomeScreen
import javax.inject.Inject

class HomeEntryImpl @Inject constructor() : HomeEntry() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val viewModel = injectedViewModel {
            DaggerHomeComponent.builder()
                .commonDependencies(LocalCommonDependencies.current)
                .dataDependencies(LocalDataDependencies.current)
                .build()
                .viewModel
        }

        HomeScreen(viewModel)
    }
}
