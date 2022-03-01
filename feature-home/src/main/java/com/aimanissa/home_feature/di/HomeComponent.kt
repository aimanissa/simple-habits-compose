package com.aimanissa.home_feature.di

import com.aimanissa.common.di.CommonDependencies
import dagger.Component

@Component(
    dependencies = [CommonDependencies::class]
)
interface HomeComponent : HomeDependencies, CommonDependencies