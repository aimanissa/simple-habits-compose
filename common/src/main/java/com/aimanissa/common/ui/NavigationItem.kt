package com.aimanissa.common.ui

import com.aimanissa.common.R

sealed class NavigationItem(var title: String, var icon: Int, var route: String) {
    class Home(route: String) : NavigationItem("Home", R.drawable.ic_baseline_home, route)
    class NewHabit(route: String) : NavigationItem("New Habit", R.drawable.ic_baseline_plus, route)
    class AllHabits(route: String) : NavigationItem("All Habits", R.drawable.ic_baseline_all, route)
}
