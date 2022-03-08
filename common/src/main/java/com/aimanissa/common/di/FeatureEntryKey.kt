package com.aimanissa.common.di

import com.aimanissa.common.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)