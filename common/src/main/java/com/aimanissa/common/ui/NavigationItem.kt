package com.aimanissa.common.ui

import com.aimanissa.common.R

sealed class NavigationItem(var title: String, var icon: Int, var route: String) {
    object Home : NavigationItem("Home", R.drawable.ic_baseline_home, "home")
    object NewHabit : NavigationItem("New Habit", R.drawable.ic_baseline_plus, "new_habit")
    object AllHabits : NavigationItem("All Habits", R.drawable.ic_baseline_all, "all_habits")
}
