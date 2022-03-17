package com.aimanissa.home_feature.di

import com.aimanissa.common.di.CommonDependencies
import com.aimanissa.data.di.DataDependencies
import com.aimanissa.home_feature.ui.HomeViewModel
import dagger.Component

@FeatureHomeScope
@Component(
    dependencies = [
        CommonDependencies::class,
        DataDependencies::class
    ]
)
interface HomeComponent : HomeDependencies, CommonDependencies, DataDependencies {

    val viewModel: HomeViewModel
}
