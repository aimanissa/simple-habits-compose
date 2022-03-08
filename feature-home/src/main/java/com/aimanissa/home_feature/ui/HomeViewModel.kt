package com.aimanissa.home_feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.usecase.HomeUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    // private val useCase: HomeUseCase
) : ViewModel()