package com.aimanissa.feature_new_habit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.usecase.NewHabitsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewHabitsViewModel @Inject constructor(
    private val useCase: NewHabitsUseCase
) : ViewModel() {

    fun saveHabitsRoster(habitsRoster: HabitsRoster) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.saveHabitsRoster(habitsRoster)
        }
    }
}
