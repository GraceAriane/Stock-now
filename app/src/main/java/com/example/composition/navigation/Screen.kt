package com.example.composition.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
    object Products : Screen("products")
    object AddEditProduct : Screen("add_edit_product")
    object Movement : Screen("movement")
    object History : Screen("history")
    object Notification : Screen("notification")
    object Export : Screen("export")
    object Settings : Screen("settings")
    object Alimentation : Screen("alimentation")
}
