package com.aimanissa.feature_new_habit.navigation.api

import com.aimanissa.common.ComposableFeatureEntry

abstract class NewHabitEntry : ComposableFeatureEntry {

    final override val featureRoute = "new_habit"

    fun destination() = featureRoute
}