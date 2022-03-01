package com.aimanissa.simplehabits

import android.app.Application
import com.aimanissa.common.di.DaggerCommonComponent
import com.aimanissa.data.di.DaggerDataComponent
import com.aimanissa.simplehabits.di.AppDependencies
import com.aimanissa.simplehabits.di.DaggerAppComponent

class HabitsApplication : Application() {

    lateinit var appDependencies: AppDependencies

    override fun onCreate() {
        super.onCreate()
        val commonComponent = DaggerCommonComponent.factory().create(this)
        val dataComponent = DaggerDataComponent.builder().commonDependencies(commonComponent).build()

        appDependencies = DaggerAppComponent.builder()
            .commonDependencies(commonComponent)
            .dataDependencies(dataComponent)
            .build()
    }
}
