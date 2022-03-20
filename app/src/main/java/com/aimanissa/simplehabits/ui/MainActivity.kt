package com.aimanissa.simplehabits.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.aimanissa.common.di.LocalCommonDependencies
import com.aimanissa.common.ui.theme.SimpleHabitsTheme
import com.aimanissa.data.di.LocalDataDependencies
import com.aimanissa.simplehabits.appDependencies
import com.aimanissa.simplehabits.di.LocalAppDependencies
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                SimpleHabitsTheme {
                    val navController = rememberNavController()
                    CompositionLocalProvider(
                        LocalAppDependencies provides application.appDependencies,
                        LocalCommonDependencies provides application.appDependencies,
                        LocalDataDependencies provides application.appDependencies
                    ) {
                        Scaffold(
                            bottomBar = {
                                HabitsBottomNavBar(navController)
                            }
                        ) {
                            NavigationGraph(navController, it)
                        }
                    }
                }
            }
        }
    }
}
