package com.example.stocknow.navigation

sealed class Screen(val route: String) {

    object Home : Screen("home")
    object Movement : Screen("movement")
    object History : Screen("history")
    object Notification : Screen("notification")
    object Export : Screen("export")
    object Settings : Screen("settings")
}

