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
import com.stocknow.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExportationScreen(onBack: () -> Unit) {

    var selectedFormat by remember { mutableStateOf("CSV") }
    val formats = listOf("PDF", ".txt", "CSV")

    Scaffold(
        containerColor = Surface1,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Outlined.ArrowBack, "Retour", tint = TextPrimary)
                    }
                },
                title = { Text("Exportation", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface0),
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

            // ── Filter rows ───────────────────────────────────────────
            FilterRow(label = "Date",     value = "1 – 30 avr.")
            FilterRow(label = "Produits", value = "Tous")
            FilterRow(label = "Type",     value = "Entrée/Sortie")

            Spacer(Modifier.height(6.dp))

            // ── Format section label ───────────────────────────────────
            Text(
                "FORMAT DE FICHIER",
                style = MaterialTheme.typography.labelSmall,
                color = TextHint,
                letterSpacing = 0.7.sp,
                modifier = Modifier.padding(vertical = 4.dp),
            )

            // ── Radio options ──────────────────────────────────────────
            formats.forEach { fmt ->
                val isSelected = fmt == selectedFormat
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Surface2)
                        .clickable { selectedFormat = fmt }
                        .padding(horizontal = 14.dp, vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    RadioButton(
                        selected = isSelected,
                        onClick  = { selectedFormat = fmt },
                        colors   = RadioButtonDefaults.colors(
                            selectedColor   = Teal400,
                            unselectedColor = TextHint,
                        ),
                        modifier = Modifier.size(20.dp),
                    )
                    Text(
                        fmt,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isSelected) Teal400 else TextPrimary,
                    )
                    if (fmt == "CSV") {
                        Spacer(Modifier.weight(1f))
                        Text(
                            "Recommandé",
                            fontSize = 10.sp,
                            color = TextHint,
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))

            // ── Export button ──────────────────────────────────────────
            Button(
                onClick = { /* TODO: trigger export */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Teal400),
            ) {
                Icon(Icons.Outlined.FileUpload, contentDescription = null, tint = Surface0, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text("Exporter", color = Surface0, fontSize = 14.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium)
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun FilterRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Surface2)
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label, style = MaterialTheme.typography.bodySmall, color = TextSecondary, modifier = Modifier.width(80.dp))
        Spacer(Modifier.weight(1f))
        Text(value, style = MaterialTheme.typography.bodyMedium, color = TextPrimary)
        Spacer(Modifier.width(8.dp))
        Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = TextHint, modifier = Modifier.size(16.dp))
    }
}
