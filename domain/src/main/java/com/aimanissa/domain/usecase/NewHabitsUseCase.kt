package com.aimanissa.domain.usecase

import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.repository.HabitsRepository
import javax.inject.Inject

class NewHabitsUseCase @Inject constructor(
    private val repository: HabitsRepository
) {

    suspend fun saveHabitsRoster(habitsRoster: HabitsRoster) {
        return repository.saveHabitsRoster(habitsRoster)
    }
}
