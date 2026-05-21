package com.example.composition.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.composition.ui.components.AppBottomBar
import com.example.composition.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Routes où la barre de navigation ne doit pas apparaître
    val authRoutes = listOf(
        Screen.Splash.route,
        Screen.Onboarding.route,
        Screen.Login.route,
        Screen.Register.route
    )

    Scaffold(
        bottomBar = {
            if (currentRoute !in authRoutes) {
                AppBottomBar(navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController)
            }
            composable(Screen.Onboarding.route) {
                OnboardingScreen(navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Register.route) {
                RegisterScreen(navController)
            }
            composable(Screen.Dashboard.route) {
                DashboardScreen(navController)
            }
            composable(Screen.Products.route) {
                ProductsScreen(navController)
            }
            composable(Screen.AddEditProduct.route) {
                AddEditProductScreen(navController)
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
                SettingsScreen(navController = navController)
            }
            composable(Screen.Alimentation.route) {
                AlimentationsScreen(navController)
            }
        }
    }
}
