package com.aimanissa.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(appContext: Context): HabitsDatabase {
        return Room.databaseBuilder(
            appContext,
            HabitsDatabase::class.java,
            "habits_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHabitsDao(database: HabitsDatabase): HabitsDao {
        return database.habitsDao()
    }
}