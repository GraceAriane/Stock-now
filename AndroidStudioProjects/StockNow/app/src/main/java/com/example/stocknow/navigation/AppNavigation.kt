package com.example.stocknow.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.*
import com.example.stocknow.screens.export.ExportScreen
import com.example.stocknow.screens.home.HomeScreen
import androidx.navigation.compose.rememberNavController
import com.example.stocknow.screens.history.HistoryScreen
import com.example.stocknow.screens.movement.MovementScreen
import com.example.stocknow.screens.notification.NotificationScreen
import com.example.stocknow.screens.settings.SettingsScreen
import com.stocknow.app.ui.components.BottomBar

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {

        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.Movement.route) {
            MovementScreen()
        }

        composable(Screen.History.route) {
            HistoryScreen()
        }

        composable(Screen.Notification.route) {
            NotificationScreen()
        }

        composable(Screen.Export.route) {
            ExportScreen()
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}