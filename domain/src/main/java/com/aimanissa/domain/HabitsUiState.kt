package com.aimanissa.domain

import com.aimanissa.domain.model.HabitsRoster

sealed class HabitsUiState {
    data class Success(val habitsRosterList: List<HabitsRoster>) : HabitsUiState()
    data class Error(val exception: Throwable) : HabitsUiState()
    object Empty : HabitsUiState()
}
