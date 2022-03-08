package com.aimanissa.home_feature.di

import com.aimanissa.common.FeatureEntry
import com.aimanissa.common.di.FeatureEntryKey
import com.aimanissa.home_feature.navigation.api.HomeEntry
import com.aimanissa.home_feature.navigation.impl.HomeEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface HomeEntryModule {

    @Binds
    @Singleton
    @[IntoMap FeatureEntryKey(HomeEntry::class)]
    fun bindHomeEntry(impl: HomeEntryImpl): FeatureEntry
}