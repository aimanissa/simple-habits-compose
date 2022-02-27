package com.aimanissa.domain.usecase

import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.repository.HabitsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val repository: HabitsRepository
) {

    suspend fun getAllHabitsRoster(): Flow<HabitsRoster> {
        return repository.getAllHabitsRoster()
    }
}