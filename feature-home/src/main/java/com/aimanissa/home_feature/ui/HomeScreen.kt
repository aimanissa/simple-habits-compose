package com.aimanissa.home_feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
    ) {
        Text(text = "Hello World!!!")
    }
}
