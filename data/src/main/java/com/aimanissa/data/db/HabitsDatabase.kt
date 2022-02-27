package com.aimanissa.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aimanissa.data.db.entity.UserGoalEntity
import com.aimanissa.data.db.entity.HabitsRosterEntity
import com.aimanissa.data.db.entity.HabitsRosterWithUserGoals
import com.aimanissa.data.db.mapper.DatabaseMapper

@Database(
    entities = [
        UserGoalEntity::class,
        HabitsRosterEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseMapper::class)
abstract class HabitsDatabase : RoomDatabase() {

    abstract fun habitsDao(): HabitsDao
}
