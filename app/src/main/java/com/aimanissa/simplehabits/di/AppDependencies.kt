package com.aimanissa.simplehabits.di

import androidx.compose.runtime.compositionLocalOf
import com.aimanissa.common.Destinations
import com.aimanissa.common.di.CommonDependencies
import com.aimanissa.data.di.DataDependencies

interface AppDependencies : CommonDependencies, DataDependencies {

    val destinations: Destinations
}

val LocalAppDependencies = compositionLocalOf<AppDependencies> { error("No app dependencies found!") }