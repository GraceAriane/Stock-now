package com.example.composition.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composition.R
import com.example.composition.ui.screens.*
import com.example.composition.ui.theme.CompositionTheme
import com.example.composition.ui.theme.screens.AddEditProductScreen
import com.example.composition.ui.theme.screens.AlimentationsScreen
import com.example.composition.ui.theme.screens.DashboardScreen
import com.example.composition.ui.theme.screens.ProductsScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    // Récupère la route actuelle pour savoir si on doit afficher la BottomBar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Routes où on affiche la BottomBar
    val routesWithBottomBar = listOf("dashboard", "products", "movements", "settings")

    Scaffold(
        bottomBar = {
            // Afficher la BottomBar UNIQUEMENT sur les routes spécifiées
            if (currentRoute in routesWithBottomBar) {
                NavigationBar(
                    containerColor = Color.White,
                    tonalElevation = 8.dp,
                    modifier = Modifier.height(75.dp)
                ) {
                    // Accueil
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = "Accueil",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = { Text("Accueil", fontSize = 11.sp) },
                        selected = currentRoute == "dashboard",
                        onClick = {
                            navController.navigate("dashboard") {
                                popUpTo("dashboard") { inclusive = true }
                                launchSingleTop = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF01596D),
                            selectedTextColor = Color(0xFF01596D),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )

                    // Mouvements
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_mouvements),
                                contentDescription = "Mouvements",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = { Text("Mouvements", fontSize = 11.sp) },
                        selected = currentRoute == "movements",
                        onClick = {
                            navController.navigate("movements") {
                                launchSingleTop = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF01596D),
                            selectedTextColor = Color(0xFF01596D),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )

                    // BOUTON + au milieu
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("add_product")
                            },
                            containerColor = Color(0xFF01596D),
                            contentColor = Color.White,
                            modifier = Modifier
                                .size(56.dp)
                                .offset(y = (-8).dp),
                            shape = androidx.compose.foundation.shape.CircleShape
                        ) {
                            Text(
                                text = "+",
                                fontSize = 28.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        }
                    }

                    // Produits
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_products),
                                contentDescription = "Produits",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = { Text("Produits", fontSize = 11.sp) },
                        selected = currentRoute == "products",
                        onClick = {
                            navController.navigate("products") {
                                popUpTo("dashboard") { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF01596D),
                            selectedTextColor = Color(0xFF01596D),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )

                    // Paramètres
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_settings),
                                contentDescription = "Paramètres",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = { Text("Paramètres", fontSize = 11.sp) },
                        selected = currentRoute == "settings",
                        onClick = {
                            navController.navigate("settings") {
                                launchSingleTop = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF01596D),
                            selectedTextColor = Color(0xFF01596D),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash",  // ← Démarre sur splash (ses écrans)
            modifier = modifier.padding(innerPadding)
        ) {
            // === SES ROUTES (sans BottomBar) ===
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

            // === TES ROUTES ===
            composable("dashboard") {
                DashboardScreen(navController)
            }

            composable("products") {
                ProductsScreen(navController)
            }

            // add_product - SANS BOTTOMBAR
            composable("add_product") {
                AddEditProductScreen(navController)
            }

            // alimentations - SANS BOTTOMBAR
            composable("alimentations") {
                AlimentationsScreen(navController)
            }

            composable("movements") {
                DashboardScreen(navController)
            }

            composable("settings") {
                DashboardScreen(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    CompositionTheme {
        AppNavigation()
    }
}