package com.stocknow.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stocknow.app.ui.components.BottomBar
import com.stocknow.app.ui.navigation.Routes
import com.stocknow.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MouvementsScreen(navController: NavHostController) {

    var typeExpanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf("Entrée") }
    val types = listOf("Entrée", "Sortie", "Perte", "Retour")

    var quantity by remember { mutableIntStateOf(10) }
    var selectedDate by remember { mutableStateOf("24 avr. 2024") }

    Scaffold(
        containerColor = Surface1,
        topBar = {
            TopAppBar(
                title = { Text("Mouvements", style = MaterialTheme.typography.titleLarge) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.NotificationsNone, contentDescription = null, tint = TextSecondary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface0),
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController // Utilise le paramètre attendu selon l'erreur
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {

            // ── Type dropdown ─────────────────────────────────────────
            FormLabel("TYPE")
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Surface2)
                        .clickable { typeExpanded = true }
                        .padding(horizontal = 14.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(selectedType, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                    Icon(Icons.Outlined.ExpandMore, contentDescription = null, tint = TextHint, modifier = Modifier.size(18.dp))
                }
                DropdownMenu(
                    expanded = typeExpanded,
                    onDismissRequest = { typeExpanded = false },
                    modifier = Modifier.background(Surface2),
                ) {
                    types.forEach { t ->
                        DropdownMenuItem(
                            text = { Text(t, color = TextPrimary) },
                            onClick = { selectedType = t; typeExpanded = false },
                        )
                    }
                }
            }

            // ── Product selector ──────────────────────────────────────
            FormLabel("PRODUITS")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Surface2)
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                // Product thumbnail
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(9.dp))
                        .background(IconBgAmber),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Outlined.WaterDrop, contentDescription = null, tint = Amber400, modifier = Modifier.size(18.dp))
                }
                Text("Huile", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = TextHint, modifier = Modifier.size(18.dp))
            }

            // ── Quantity stepper ──────────────────────────────────────
            FormLabel("QUANTITÉ")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Surface2)
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Quantité", style = MaterialTheme.typography.bodySmall, color = TextSecondary, modifier = Modifier.weight(1f))
                Stepper(
                    value = quantity,
                    onDecrement = { if (quantity > 1) quantity-- },
                    onIncrement = { quantity++ },
                )
            }

            // ── Date picker row ───────────────────────────────────────
            FormLabel("DATE")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Surface2)
                    .padding(horizontal = 14.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(selectedDate, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                Icon(Icons.Outlined.CalendarToday, contentDescription = null, tint = TextHint, modifier = Modifier.size(18.dp))
            }

            Spacer(Modifier.weight(1f))

            // ── Save button ───────────────────────────────────────────
            Button(
                onClick = { /* TODO: save movement */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Teal400),
            ) {
                Icon(Icons.Outlined.Check, contentDescription = null, tint = Surface0, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text("Enregistrer", color = Surface0, fontSize = 14.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium)
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun FormLabel(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.labelSmall,
        color = TextHint,
        letterSpacing = 0.7.sp,
        modifier = Modifier.padding(top = 4.dp, bottom = 2.dp),
    )
}

@Composable
private fun Stepper(value: Int, onDecrement: () -> Unit, onIncrement: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Minus
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Surface3)
                .clickable(onClick = onDecrement),
            contentAlignment = Alignment.Center,
        ) {
            Icon(Icons.Outlined.Remove, contentDescription = "Diminuer", tint = TextSecondary, modifier = Modifier.size(14.dp))
        }

        Text(
            value.toString(),
            style = MaterialTheme.typography.titleSmall,
            color = TextPrimary,
            modifier = Modifier.widthIn(min = 28.dp),
        )

        // Plus
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Surface3)
                .clickable(onClick = onIncrement),
            contentAlignment = Alignment.Center,
        ) {
            Icon(Icons.Outlined.Add, contentDescription = "Augmenter", tint = TextSecondary, modifier = Modifier.size(14.dp))
        }
    }
}
