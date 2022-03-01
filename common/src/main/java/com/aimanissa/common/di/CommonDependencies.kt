package com.aimanissa.common.di

import android.content.Context
import androidx.compose.runtime.compositionLocalOf

interface CommonDependencies {

    val context: Context
}

val LocalCommonDependencies = compositionLocalOf<CommonDependencies> { error("No common dependencies found!") }