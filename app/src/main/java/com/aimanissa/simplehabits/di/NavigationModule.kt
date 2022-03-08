package com.aimanissa.simplehabits.di

import com.aimanissa.feature_new_habit.di.NewHabitEntryModule
import com.aimanissa.home_feature.di.HomeEntryModule
import dagger.Module

@Module(
    includes = [
        HomeEntryModule::class,
        NewHabitEntryModule::class
    ]
)
interface NavigationModule