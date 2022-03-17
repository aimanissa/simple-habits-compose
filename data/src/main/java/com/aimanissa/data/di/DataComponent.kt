package com.aimanissa.data.di

import com.aimanissa.common.di.CommonDependencies
import com.aimanissa.data.db.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonDependencies::class],
    modules = [DataModule::class]
)
interface DataComponent : DataDependencies
