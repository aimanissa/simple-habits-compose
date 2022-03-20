package com.aimanissa.domain.model

data class UserGoal(
    val goalId: Long = 0L,
    val rosterCreatorId: Long = 0L,
    val name: String,
    val isDone: Boolean = false
)