package com.aimanissa.simplehabits.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.aimanissa.common.find
import com.aimanissa.common.ui.NavigationItem
import com.aimanissa.feature_new_habit.navigation.api.NewHabitEntry
import com.aimanissa.home_feature.navigation.api.HomeEntry
import com.aimanissa.simplehabits.di.LocalAppDependencies
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun HabitsBottomNavBar(navController: NavHostController) {
    val destinations = LocalAppDependencies.current.destinations
    val currentRoute: String? = navController.currentDestination?.route

    val homeRoute = destinations.find<HomeEntry>().featureRoute
    val newHabitRoute = destinations.find<NewHabitEntry>().featureRoute

    val tabs = listOf(
        NavigationItem.Home(homeRoute),
        NavigationItem.NewHabit(newHabitRoute),
        NavigationItem.AllHabits("all_habits")
    )

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = tab.icon),
                        contentDescription = tab.title
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        style = MaterialTheme.typography.caption
                    )
                },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onSecondary,
                alwaysShowLabel = true,
                selected = currentRoute == tab.route,
                onClick = {
                    navController.navigate(tab.route) {
                        launchSingleTop = true
                        restoreState = true
                        // Pop up backstack to the first destination and save state. This makes going back
                        // to the start destination when pressing back in any other bottom tab.
                        popUpTo(findStartDestination(navController.graph).id) {
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}
