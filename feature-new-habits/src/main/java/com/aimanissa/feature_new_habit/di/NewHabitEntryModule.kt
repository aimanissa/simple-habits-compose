package com.aimanissa.feature_new_habit.di

import com.aimanissa.common.FeatureEntry
import com.aimanissa.common.di.FeatureEntryKey
import com.aimanissa.feature_new_habit.navigation.api.NewHabitEntry
import com.aimanissa.feature_new_habit.navigation.impl.NewHabitEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface NewHabitEntryModule {

    @Binds
    @Singleton
    @[IntoMap FeatureEntryKey(NewHabitEntry::class)]
    fun bindNewHabitEntry(impl: NewHabitEntryImpl): FeatureEntry
}