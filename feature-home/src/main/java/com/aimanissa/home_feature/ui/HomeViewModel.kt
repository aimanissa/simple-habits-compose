package com.aimanissa.home_feature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aimanissa.domain.HabitsUiState
import com.aimanissa.domain.usecase.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HabitsUiState>(HabitsUiState.Success(emptyList()))
    val uiState: StateFlow<HabitsUiState> = _uiState

    init {
        viewModelScope.launch {
            useCase.getAllHabitsRoster()
                .catch { exception ->
                    _uiState.value = HabitsUiState.Error(exception)
                    Log.e(TAG, "Something went wrong with getAllHabitsRoster(): $exception")
                }
                .collect { habitsRosterList ->
                    _uiState.value = HabitsUiState.Success(habitsRosterList)
                    Log.e(TAG, "Success $habitsRosterList")
                }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}
