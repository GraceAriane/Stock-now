package com.stocknow.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun StockNowNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home" // Remplacez par votre route de départ
    ) {
        composable("home") {
            // Appel de votre écran d'accueil
        }
        // Ajoutez vos autres routes ici (Mouvements, Paramètres, etc.)
    }
}

