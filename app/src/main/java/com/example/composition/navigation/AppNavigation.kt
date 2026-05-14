package com.example.composition.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.composition.ui.screens.OnboardingScreen
import com.example.composition.ui.screens.SplashScreen

/**
 * Gère la navigation principale de l'application.
 *
 * Définit les différentes routes accessibles
 * ainsi que l'écran de démarrage.
 */
@Composable
fun AppNavigation() {

    // Contrôleur utilisé pour gérer les changements d'écran
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        // Écran de démarrage
        composable("splash") {

            SplashScreen(navController)
        }

        // Écran d'onboarding
        composable("onboarding") {

            OnboardingScreen(navController)
        }

        // Futur écran principal de l'application
        composable("home") {

        }
    }
}