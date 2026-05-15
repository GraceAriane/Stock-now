package com.example.composition.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.composition.ui.screens.*


/**
 * Gère la navigation principale de l'application.
 *
 * Définit les différentes routes accessibles
 * ainsi que l'écran de démarrage.
 */
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {

            SplashScreen(navController)
        }

        composable("onboarding") {

            OnboardingScreen(navController)
        }

        composable("login") {

            LoginScreen(navController)
        }

        composable("register") {

            RegisterScreen(navController)
        }

        composable("home") {

        }
    }
}