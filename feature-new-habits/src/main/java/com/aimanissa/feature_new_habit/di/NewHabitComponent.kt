package com.aimanissa.feature_new_habit.di

import com.aimanissa.common.di.CommonDependencies
import com.aimanissa.data.di.DataDependencies
import com.aimanissa.feature_new_habit.ui.NewHabitsViewModel
import dagger.Component

@Component(
    dependencies = [
        CommonDependencies::class,
        DataDependencies::class
    ]
)
interface NewHabitComponent : NewHabitDependencies, CommonDependencies, DataDependencies {

    val viewModel: NewHabitsViewModel
}
