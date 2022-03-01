package com.aimanissa.data.di

import androidx.compose.runtime.compositionLocalOf
import com.aimanissa.domain.repository.HabitsRepository

interface DataDependencies {

    val habitsRepository: HabitsRepository
}

val LocalDataDependencies = compositionLocalOf<DataDependencies> { error("No data dependencies found!") }