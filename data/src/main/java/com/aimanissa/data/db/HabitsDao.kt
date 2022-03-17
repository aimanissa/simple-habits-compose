package com.aimanissa.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.aimanissa.data.db.entity.HabitsRosterEntity
import com.aimanissa.data.db.entity.HabitsRosterWithUserGoals
import com.aimanissa.data.db.entity.UserGoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHabitsRosterEntity(entity: HabitsRosterEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserGoalsEntityList(entityList: List<UserGoalEntity>)

    @Transaction
    suspend fun insertHabitsRosterWithUserGoals(habitsRoster: HabitsRosterEntity, userGoals: List<UserGoalEntity>) {
        val rosterId = insertHabitsRosterEntity(habitsRoster)
        userGoals.forEach {
            it.rosterCreatorId = rosterId
        }
        insertUserGoalsEntityList(userGoals)
    }

    @Transaction
    @Query("SELECT * FROM ${HabitsRosterEntity.TABLE_NAME}")
    fun getAllHabitsRosterWithUserGoals(): Flow<List<HabitsRosterWithUserGoals>>

    @Query("DELETE FROM ${HabitsRosterEntity.TABLE_NAME} WHERE ${HabitsRosterEntity.ROSTER_ID}=(:rosterId)")
    suspend fun deleteHabitsRosterEntity(rosterId: Long)

    // @Query("DELETE FROM ${UserGoalEntity.TABLE_NAME} WHERE ${UserGoalEntity.ROSTER_CREATOR_ID} IN (:rosterCreatorIds)")
    // fun deleteUserGoalsEntityList(rosterCreatorIds: List<Long>)
    //
    // @Transaction
    // suspend fun deleteHabitsRosterWithUserGoals(rosterId: Long) {
    //     deleteHabitsRosterEntity(rosterId)
    //     deleteUserGoalsEntityList(listOf(rosterId))
    // }
}
