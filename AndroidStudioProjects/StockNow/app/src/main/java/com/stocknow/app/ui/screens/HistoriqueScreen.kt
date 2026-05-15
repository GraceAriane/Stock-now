package com.stocknow.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stocknow.app.ui.theme.*

// ── Sample data model ────────────────────────────────────────────────────────
data class MouvementItem(
    val produit: String,
    val type: String,       // "Entrée" | "Sortie"
    val motif: String,      // "Vente" | "Approvisionnement" | "Perte"
    val date: String,
    val quantite: Int,
)

private val sampleData = listOf(
    // Today
    MouvementItem("Produit A", "Sortie",  "Vente",             "12/04/2025", -30),
    MouvementItem("Produit B", "Entrée",  "Approvisionnement", "12/04/2025", +50),
    MouvementItem("Produit C", "Entrée",  "Approvisionnement", "12/04/2025", +30),
    // Yesterday
    MouvementItem("Produit D", "Entrée",  "Approvisionnement", "11/04/2025", +70),
    MouvementItem("Produit A", "Sortie",  "Vente",             "11/04/2025", -30),
    MouvementItem("Produit B", "Sortie",  "Vente",             "11/04/2025", -20),
)

private val filterChips = listOf("Tous", "Entrées", "Sorties", "Pertes")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoriqueScreen(onBack: () -> Unit) {

    var selectedFilter by remember { mutableStateOf("Tous") }

    val grouped = remember(selectedFilter) {
        val filtered = when (selectedFilter) {
            "Entrées" -> sampleData.filter { it.type == "Entrée" }
            "Sorties" -> sampleData.filter { it.type == "Sortie" }
            "Pertes"  -> sampleData.filter { it.motif == "Perte" }
            else      -> sampleData
        }
        // Group by date label
        mapOf(
            "Aujourd'hui" to filtered.filter { it.date == "12/04/2025" },
            "Hier"        to filtered.filter { it.date == "11/04/2025" },
        ).filter { it.value.isNotEmpty() }
    }

    Scaffold(
        containerColor = Surface1,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Retour", tint = TextPrimary)
                    }
                },
                title = { Text("Historique", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface0),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            // ── Search bar ─────────────────────────────────────────────
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Surface2)
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(Icons.Outlined.Search, null, tint = TextHint, modifier = Modifier.size(16.dp))
                    Text("Rechercher…", color = TextHint, fontSize = 13.sp)
                }
            }

            // ── Filter chips ───────────────────────────────────────────
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    items(filterChips) { chip ->
                        val selected = chip == selectedFilter
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(if (selected) Teal400.copy(alpha = .15f) else Surface2)
                                .clickable { selectedFilter = chip }
                                .padding(horizontal = 14.dp, vertical = 7.dp),
                        ) {
                            Text(
                                chip,
                                fontSize = 12.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                                color = if (selected) Teal400 else TextHint,
                            )
                        }
                    }
                }
            }

            // ── Grouped list ───────────────────────────────────────────
            grouped.forEach { (day, items) ->
                item {
                    Text(
                        day,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = TextHint,
                        letterSpacing = 0.7.sp,
                    )
                }
                items(items) { mouvement ->
                    HistoriqueRow(mouvement)
                }
            }

            item { Spacer(Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun HistoriqueRow(item: MouvementItem) {
    val isEntree = item.type == "Entrée"
    val dotColor  = if (isEntree) Teal400 else Red400
    val iconBg    = if (isEntree) IconBgGreen else IconBgRed
    val iconTint  = if (isEntree) Teal400 else Red400
    val qtyColor  = if (isEntree) Teal400 else Red400
    val qtyText   = if (isEntree) "+${item.quantite}" else "${item.quantite}"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Surface2)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Dot indicator
        Box(
            modifier = Modifier
                .size(7.dp)
                .clip(CircleShape)
                .background(dotColor),
        )

        // Type icon
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(iconBg),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                if (isEntree) Icons.Outlined.ArrowUpward else Icons.Outlined.ArrowDownward,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(16.dp),
            )
        }

        // Info
        Column(modifier = Modifier.weight(1f)) {
            Text(item.produit, style = MaterialTheme.typography.bodyMedium, color = TextPrimary)
            Text(
                "${item.motif} · ${item.date}",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 10.sp,
            )
        }

        // Quantity
        Text(qtyText, fontSize = 14.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium, color = qtyColor)
    }
}
