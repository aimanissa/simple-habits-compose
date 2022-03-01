package com.aimanissa.simplehabits.di

import com.aimanissa.common.di.CommonDependencies
import com.aimanissa.data.di.DataDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonDependencies::class,
        DataDependencies::class
    ]
)
interface AppComponent : AppDependencies
