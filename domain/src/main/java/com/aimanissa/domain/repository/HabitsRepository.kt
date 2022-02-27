package com.aimanissa.domain.repository

import com.aimanissa.domain.model.HabitsRoster
import kotlinx.coroutines.flow.Flow

interface HabitsRepository {

    suspend fun getAllHabitsRoster(): Flow<HabitsRoster>

    suspend fun saveHabitsRoster(habitsRoster: HabitsRoster)

    suspend fun deleteHabitsRoster(rosterId: Long)
}
