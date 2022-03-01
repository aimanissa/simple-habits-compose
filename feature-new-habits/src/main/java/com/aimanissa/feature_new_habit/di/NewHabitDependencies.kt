package com.aimanissa.feature_new_habit.di

import androidx.compose.runtime.compositionLocalOf

interface NewHabitDependencies

val LocalNewHabitDependencies = compositionLocalOf<NewHabitDependencies> { error("No new habit dependencies found!") }