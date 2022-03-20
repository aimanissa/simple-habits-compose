package com.aimanissa.domain.model

import java.util.*

data class HabitsRoster(
    val rosterId: Long = 0L,
    var title: String = "",
    val date: Date = Date(System.currentTimeMillis()),
    val percentComplete: Int = 0,
    val isSelected: Boolean = false,
    var userGoals: List<UserGoal> = emptyList()
)
