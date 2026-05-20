package com.example.composition.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Movement : Screen("movement")
    object History : Screen("history")
    object Notification : Screen("notification")
    object Export : Screen("export")
    object Settings : Screen("settings")
}
