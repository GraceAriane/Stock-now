package com.stocknow.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stocknow.app.ui.components.BottomBar
import com.stocknow.app.ui.navigation.Routes
import com.stocknow.app.ui.theme.*

// ── Data class for a settings entry ─────────────────────────────────────────
data class SettingsEntry(
    val label: String,
    val subtitle: String,
    val icon: ImageVector,
    val iconBg: Color,
    val iconTint: Color,
    val route: String? = null,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParametresScreen(navController: NavHostController, onNavigate: (String) -> Unit) {

    val entries = listOf(
        SettingsEntry("Thèmes",       "Apparence de l'app",    Icons.Outlined.Palette,         IconBgGreen,  Teal400),
        SettingsEntry("Préférences",  "Langue, devise, région", Icons.Outlined.Tune,            IconBgPurple, Color(0xFF9F8DFF)),
        SettingsEntry("Exportation",  "CSV, PDF, .txt",         Icons.Outlined.FileUpload,      IconBgAmber,  Amber400,  Routes.EXPORTATION),
        SettingsEntry("Historique",   "Mouvements passés",      Icons.Outlined.History,         IconBgBlue,   Blue400,   Routes.HISTORIQUE),
        SettingsEntry("Notifications","Alertes de stock",       Icons.Outlined.NotificationsNone,IconBgGreen, Teal400,   Routes.NOTIFICATIONS),
        SettingsEntry("Autres",       "À propos, support",      Icons.Outlined.MoreHoriz,       Surface3,     TextHint),
    )

    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Surface1,
        topBar = {
            Column(modifier = Modifier.background(Surface0)) {
                TopAppBar(
                    title = {
                        Text(
                            "Paramètres",
                            style = MaterialTheme.typography.titleLarge,
                            color = TextPrimary,
                        )
                    },
                    actions = {
                        IconButton(onClick = { onNavigate(Routes.NOTIFICATIONS) }) {
                            Icon(Icons.Outlined.NotificationsNone, contentDescription = "Notifications", tint = TextSecondary)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface0),
                )
            }
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {

            // ── Search bar ───────────────────────────────────────────────
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Surface2)
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(Icons.Outlined.Search, contentDescription = null, tint = TextHint, modifier = Modifier.size(16.dp))
                    Text("Rechercher…", color = TextHint, fontSize = 13.sp)
                }
            }

            // ── Menu items ───────────────────────────────────────────────
            items(entries.size) { i ->
                val entry = entries[i]
                SettingsItem(entry = entry, onClick = { entry.route?.let { onNavigate(it) } })
            }
        }
    }
}

@Composable
private fun SettingsItem(entry: SettingsEntry, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Surface2)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // Icon badge
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(entry.iconBg),
            contentAlignment = Alignment.Center,
        ) {
            Icon(entry.icon, contentDescription = null, tint = entry.iconTint, modifier = Modifier.size(18.dp))
        }

        // Labels
        Column(modifier = Modifier.weight(1f)) {
            Text(entry.label,    style = MaterialTheme.typography.titleSmall)
            Text(entry.subtitle, style = MaterialTheme.typography.bodySmall, fontSize = 11.sp)
        }

        // Arrow
        Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = TextHint, modifier = Modifier.size(18.dp))
    }
}
