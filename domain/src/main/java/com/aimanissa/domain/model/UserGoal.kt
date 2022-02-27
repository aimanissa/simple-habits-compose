package com.aimanissa.domain.model

data class UserGoal(
    val goalId: Long,
    val rosterCreatorId: Long,
    val name: String,
    val isDone: Boolean
)