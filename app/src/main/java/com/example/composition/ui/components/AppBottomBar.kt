package com.example.composition.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composition.navigation.Screen
import com.example.composition.ui.theme.PrimaryGreen

@Composable
fun AppBottomBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Box {
        NavigationBar(
            containerColor = Color.White
        ) {
            NavigationBarItem(
                selected = currentRoute == Screen.Home.route,
                onClick = { 
                    if (currentRoute != Screen.Home.route) {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    }
                },
                icon = { Icon(Icons.Outlined.Home, contentDescription = null) },
                label = { Text("Accueil") }
            )

            NavigationBarItem(
                selected = currentRoute == Screen.Movement.route,
                onClick = { 
                    if (currentRoute != Screen.Movement.route) {
                        navController.navigate(Screen.Movement.route)
                    }
                },
                icon = { Icon(Icons.Outlined.SwapVert, contentDescription = null) },
                label = { Text("Mouv.") }
            )

            // Espace vide pour le bouton flottant
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = { Box(modifier = Modifier.size(24.dp)) },
                label = { }
            )

            NavigationBarItem(
                selected = currentRoute == Screen.History.route,
                onClick = { 
                    if (currentRoute != Screen.History.route) {
                        navController.navigate(Screen.History.route)
                    }
                },
                icon = { Icon(Icons.Outlined.History, contentDescription = null) },
                label = { Text("Historique") }
            )

            NavigationBarItem(
                selected = currentRoute == Screen.Settings.route,
                onClick = { 
                    if (currentRoute != Screen.Settings.route) {
                        navController.navigate(Screen.Settings.route)
                    }
                },
                icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                label = { Text("Param.") }
            )
        }

        FloatingActionButton(
            onClick = { /* Action pour ajouter un produit par exemple */ },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-28).dp),
            containerColor = Color(0xFF0F766E), // Utilisation de la couleur primaire
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
        }
    }
}
