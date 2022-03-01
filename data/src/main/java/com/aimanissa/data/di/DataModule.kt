package com.aimanissa.data.di

import com.aimanissa.data.HabitsRepositoryImpl
import com.aimanissa.domain.repository.HabitsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindHabitsRepository(impl: HabitsRepositoryImpl): HabitsRepository
}
