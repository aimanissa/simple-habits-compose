package com.aimanissa.feature_new_habit.di

import com.aimanissa.common.di.CommonDependencies
import dagger.Component

@Component(
    dependencies = [CommonDependencies::class]
)
interface NewHabitComponent : NewHabitDependencies, CommonDependencies