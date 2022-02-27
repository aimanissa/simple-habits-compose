package com.aimanissa.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class HabitsRosterWithUserGoals(
    @Embedded val habitsRoster: HabitsRosterEntity,
    @Relation(
        parentColumn = HabitsRosterEntity.ROSTER_ID,
        entityColumn = UserGoalEntity.ROSTER_CREATOR_ID
    )
    val userGoals: List<UserGoalEntity>
)
