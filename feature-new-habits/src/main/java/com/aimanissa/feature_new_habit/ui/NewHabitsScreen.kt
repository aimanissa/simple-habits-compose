package com.aimanissa.feature_new_habit.ui

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aimanissa.domain.model.HabitsRoster
import com.aimanissa.domain.model.UserGoal

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NewHabitsScreen(navController: NavHostController, viewModel: NewHabitsViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val habitsRosterTitle = remember { mutableStateOf("") }
    val goalsCounter = remember { mutableStateOf(3) }
    val userGoalsMap = remember { mutableMapOf<Int, String>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Название вашего списка привычек")
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = habitsRosterTitle.value,
                onValueChange = { habitsRosterTitle.value = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    focusedBorderColor = MaterialTheme.colors.onSurface
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Какие ежедневные действия вы хотите совершать? Добавьте несколько.")
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn {
                items(goalsCounter.value) { index ->
                    val userGoalName = remember { mutableStateOf("") }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            value = userGoalName.value,
                            onValueChange = {
                                userGoalName.value = it
                                userGoalsMap[index] = userGoalName.value
                            },
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    keyboardController?.hide()
                                }
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = MaterialTheme.colors.surface,
                                focusedBorderColor = MaterialTheme.colors.onSurface
                            )
                        )
                        IconButton(
                            enabled = index > 0,
                            onClick = {
                                goalsCounter.value -= 1
                            }
                        ) {
                            if (index > 0) {
                                Icon(
                                    painter = rememberVectorPainter(image = Icons.Filled.Delete),
                                    contentDescription = "delete",
                                    tint = Color.DarkGray
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                onClick = {
                    val userGoalsList = userGoalsMap.values.map { name ->
                        UserGoal(name = name)
                    }
                    viewModel.saveHabitsRoster(
                        HabitsRoster(
                            title = habitsRosterTitle.value,
                            userGoals = userGoalsList
                        )
                    )
                    // TODO clean all fields
                    navController.navigate("home")
                }
            ) {
                Text(text = "Сохранить")
            }
        }
    }
}
