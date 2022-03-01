package com.aimanissa.home_feature.di

import androidx.compose.runtime.compositionLocalOf

interface HomeDependencies

val LocalHomeDependencies = compositionLocalOf<HomeDependencies> { error("No home dependencies found!") }