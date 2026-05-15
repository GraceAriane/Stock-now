package com.stocknow.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stocknow.navigation.Screen
import com.stocknow.app.ui.navigation.NavItem

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(

        NavItem(
            Screen.Home.route,
            Icons.Outlined.Home,
            "Accueil"
        ),

        NavItem(
            Screen.Movement.route,
            Icons.Outlined.SwapVert,
            "Mouv."
        ),

        NavItem(
            "fab",
            Icons.Outlined.Add,
            ""
        ),

        NavItem(
            Screen.History.route,
            Icons.Outlined.Inventory,
            "Histor."
        ),

        NavItem(
            Screen.Settings.route,
            Icons.Outlined.Settings,
            "Param."
        ),

        NavItem(
            Screen.Notification.route,
            Icons.Outlined.Notifications,
            "Notif"
        )
    )

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route

    NavigationBar {

        items.forEach { item ->

            if (item.route == "fab") {

                NavigationBarItem(
                    selected = false,
                    onClick = { },

                    icon = {

                        FloatingActionButton(
                            onClick = { },
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = null
                            )
                        }
                    },

                    label = { }
                )

            } else {

                NavigationBarItem(
                    selected = currentRoute == item.route,

                    onClick = {
                        navController.navigate(item.route)
                    },

                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },

                    label = {
                        Text(item.label)
                    }
                )
            }
        }
    }
}