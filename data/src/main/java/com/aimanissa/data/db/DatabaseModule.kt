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
            HABITS_DATABASE
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHabitsDao(database: HabitsDatabase): HabitsDao {
        return database.habitsDao()
    }

    companion object {
        private const val HABITS_DATABASE = "habits_database"
    }
}
