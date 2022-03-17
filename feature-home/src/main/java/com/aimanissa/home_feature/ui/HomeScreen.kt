package com.aimanissa.home_feature.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aimanissa.domain.HabitsUiState
import com.aimanissa.domain.model.HabitsRoster
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is HabitsUiState.Success -> {
            DailyHabitsCard(state.habitsRosterList)
        }
        is HabitsUiState.Error -> {}
        is HabitsUiState.Empty -> {}
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DailyHabitsCard(habitsRosterList: List<HabitsRoster>) {
    val pagerState = rememberPagerState(pageCount = habitsRosterList.count())
    HorizontalPager(
        itemSpacing = 8.dp,
        state = pagerState
    ) { index ->
        val habitsRoster = habitsRosterList[index]
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row() {
                Text(text = habitsRoster.date.toString())
            }
            LazyColumn {
                items(habitsRoster.userGoals) { goal ->
                    Row() {
                        Text(text = goal.name)
                        Checkbox(checked = goal.isDone, onCheckedChange = {})
                    }
                    Divider()
                }
            }
        }
    }
}
