package com.aimanissa.home_feature.navigation.api

import com.aimanissa.common.ComposableFeatureEntry

abstract class HomeEntry : ComposableFeatureEntry {

    final override val featureRoute = "home"

    fun destination() = featureRoute
}