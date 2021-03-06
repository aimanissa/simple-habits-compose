package com.aimanissa.data

import com.aimanissa.data.db.HabitsDao
import com.aimanissa.data.db.mapper.DatabaseMapper
import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.repository.HabitsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitsRepositoryImpl @Inject constructor(
    private val mapper: DatabaseMapper,
    private val habitsDao: HabitsDao
) : HabitsRepository {

    override suspend fun getAllHabitsRoster(): Flow<List<HabitsRoster>> {
        return habitsDao.getAllHabitsRosterWithUserGoals()
            .map { entity -> mapper.entityListToHabitsRosterList(entity) }
    }

    override suspend fun saveHabitsRoster(habitsRoster: HabitsRoster) {
        habitsDao.insertHabitsRosterWithUserGoals(
            habitsRoster = mapper.habitsRosterToEntity(habitsRoster),
            userGoals = mapper.userGoalsListToEntityList(habitsRoster.userGoals)
        )
    }

    override suspend fun deleteHabitsRoster(rosterId: Long) {
        habitsDao.deleteHabitsRosterEntity(rosterId)
    }
}
