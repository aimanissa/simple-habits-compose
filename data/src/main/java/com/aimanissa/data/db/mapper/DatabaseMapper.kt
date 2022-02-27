package com.aimanissa.data.db.mapper

import android.util.Log
import androidx.room.TypeConverter
import com.aimanissa.data.db.entity.HabitsRosterEntity
import com.aimanissa.data.db.entity.HabitsRosterWithUserGoals
import com.aimanissa.data.db.entity.UserGoalEntity
import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.model.UserGoal
import java.util.Date
import javax.inject.Inject

class DatabaseMapper @Inject constructor() {

    private fun entityToUserGoal(entity: UserGoalEntity): UserGoal {
        return UserGoal(
            goalId = entity.goalId,
            rosterCreatorId = entity.rosterCreatorId,
            name = entity.name,
            isDone = entity.isDone
        )
    }

    private fun entityListToUserGoalsList(entityList: List<UserGoalEntity>): List<UserGoal> {
        val userGoalsList = mutableListOf<UserGoal>()
        for (entity in entityList) {
            userGoalsList.add(entityToUserGoal(entity))
        }
        return userGoalsList
    }

    fun entityListToHabitsRosterList(entityRoster: List<HabitsRosterWithUserGoals>): List<HabitsRoster> {
        val habitsRosterList = mutableListOf<HabitsRoster>()
        for (entity in entityRoster) {
            habitsRosterList.add(entityToHabitsRoster(entity))
        }
        return habitsRosterList
    }

    fun entityToHabitsRoster(entity: HabitsRosterWithUserGoals): HabitsRoster {
        return HabitsRoster(
            rosterId = entity.habitsRoster.rosterId,
            title = entity.habitsRoster.title,
            date = entityDateToHabitsRosterDate(entity.habitsRoster.date),
            percentComplete = entity.habitsRoster.percentComplete,
            isSelected = entity.habitsRoster.isSelected,
            userGoals = entityListToUserGoalsList(entity.userGoals)
        )
    }

    fun userGoalToEntity(userGoal: UserGoal): UserGoalEntity {
        return UserGoalEntity(
            goalId = userGoal.goalId,
            rosterCreatorId = userGoal.rosterCreatorId,
            name = userGoal.name,
            isDone = userGoal.isDone
        )
    }

    fun userGoalsListToEntityList(userHabitsList: List<UserGoal>): List<UserGoalEntity> {
        val userGoalsEntityList = mutableListOf<UserGoalEntity>()
        for (userHabit in userHabitsList) {
            userGoalsEntityList.add(userGoalToEntity(userHabit))
        }
        return userGoalsEntityList
    }

    fun habitsRosterToEntity(habitsRoster: HabitsRoster): HabitsRosterEntity {
        return HabitsRosterEntity(
            rosterId = habitsRoster.rosterId,
            title = habitsRoster.title,
            date = habitsRosterDateToEntityDate(habitsRoster.date),
            percentComplete = habitsRoster.percentComplete,
            isSelected = habitsRoster.isSelected
        )
    }

    @TypeConverter
    fun entityDateToHabitsRosterDate(entityDate: Long): Date {
        Log.d("DatabaseMapper", "entityDate: $entityDate")
        return Date(entityDate)
    }

    @TypeConverter
    fun habitsRosterDateToEntityDate(date: Date?): Long {
        Log.d("DatabaseMapper", "date: $date")
        return date?.time ?: 0L
    }
}
