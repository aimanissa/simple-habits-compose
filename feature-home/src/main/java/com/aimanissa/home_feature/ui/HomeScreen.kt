package com.aimanissa.home_feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
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
        modifier = Modifier.background(MaterialTheme.colors.background),
        itemSpacing = 8.dp,
        state = pagerState
    ) { index ->
        val habitsRoster = habitsRosterList[index]
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 15.dp)
                .background(MaterialTheme.colors.surface),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        text = habitsRoster.title
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn {
                    items(habitsRoster.userGoals) { goal ->
                        val checkedState = remember { mutableStateOf(goal.isDone) }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box {
                            Row() {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f),
                                    text = goal.name
                                )
                                Checkbox(
                                    checked = checkedState.value,
                                    onCheckedChange = { checkedState.value = it }
                                )
                            }
                        }
                        Divider(modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}
