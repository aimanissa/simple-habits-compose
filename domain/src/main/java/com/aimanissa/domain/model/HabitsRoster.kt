package com.aimanissa.domain.model

import java.util.*

data class HabitsRoster(
    val rosterId: Long,
    val title: String,
    val date: Date,
    val percentComplete: Int,
    val isSelected: Boolean,
    val userGoals: List<UserGoal>
)
