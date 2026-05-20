package com.example.stocknow.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stocknow.ui.viewmodels.SettingsViewModel

private val PrimaryColor = Color(0xFF0F766E)
private val BackgroundColor = Color(0xFFF5F5F5)
private val CardColor = Color.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {

    // On récupère les réglages actuels du ViewModel
    val currentSettings by viewModel.settings

    Scaffold(
        containerColor = BackgroundColor,

        bottomBar = {
            BottomNavigationBar()
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Paramètres",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                SearchSection(viewModel)

                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                SettingsCard(
                    icon = Icons.Outlined.Palette,
                    title = "Thèmes"
                )
            }

            item {
                SettingsCard(
                    icon = Icons.Outlined.Tune,
                    title = "Préférences"
                )
            }

            item {
                SettingsCard(
                    icon = Icons.Outlined.FileDownload,
                    title = "Exportation"
                )
            }

            item {
                SettingsCard(
                    icon = Icons.Outlined.History,
                    title = "Historique"
                )
            }

            item {
                SettingsCard(
                    icon = Icons.Outlined.Settings,
                    title = "Autres"
                )
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun SearchSection(viewModel: SettingsViewModel) {

    OutlinedTextField(
        // AJOUT : Lien avec la variable du ViewModel
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text("Rechercher...")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = Color.LightGray
        )
    )
}

@Composable
fun SettingsCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { },

        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),

        shape = RoundedCornerShape(20.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(PrimaryColor.copy(alpha = 0.1f)),

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = PrimaryColor
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {

    Box {

        NavigationBar(
            containerColor = Color.White
        ) {

            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Accueil")
                }
            )

            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        Icons.Outlined.SwapVert,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Mouv.")
                }
            )

            // espace vide pour le bouton +
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Box(
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { }
            )

            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        Icons.Outlined.ProductionQuantityLimits,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Produit.")
                }
            )

            NavigationBarItem(
                selected = true,
                onClick = { },
                icon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Param.")
                }
            )
        }

        // BOUTON + AU MILIEU
        FloatingActionButton(
            onClick = { },

            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-28).dp),

            containerColor = PrimaryColor,
            contentColor = Color.White,
            shape = CircleShape
        ) {

            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = null
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}