package com.aimanissa.common.di

import android.content.Context
import com.aimanissa.common.FeatureDestinationsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface CommonComponent : CommonDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CommonComponent
    }
}