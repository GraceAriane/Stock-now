package com.example.composition.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composition.ui.theme.PrimaryGreen
import kotlinx.coroutines.delay

/**
 * Écran de démarrage de l'application.
 *
 * Affiche brièvement le logo avant
 * de rediriger l'utilisateur vers l'onboarding.
 */
@Composable
fun SplashScreen(
    navController: NavController
) {

    LaunchedEffect(Unit) {
        // Temps d'affichage du splash screen
        delay(1200)

        navController.navigate("onboarding") {
            // Retire le splash de la pile de navigation
            popUpTo("splash") {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryGreen),
        contentAlignment = Alignment.Center
    ) {
        // Logo / nom de l'application
        Text(
            text = "📦 StockNow",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}
