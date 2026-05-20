package com.example.stocknow.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stocknow.ui.viewmodels.HistoriqueViewModel

private val PrimaryColor = Color(0xFF0F766E)

data class HistoryItem(
    val emoji: String,
    val type: String,
    val operation: String,
    val date: String,
    val quantity: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(viewModel: HistoriqueViewModel = viewModel()) {

    // 1. On observe les données réelles du ViewModel
    val movementsFirebase by viewModel.mouvements

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = { }
            ) {

                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Historique",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SEARCH
        OutlinedTextField(
            value = viewModel.searchQuery.value,
            onValueChange = {viewModel.searchQuery.value = it },

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

        Spacer(modifier = Modifier.height(18.dp))

        // FILTERS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FilterChipCard("Tous")
            FilterChipCard("Date")
            FilterChipCard("Quantité")
        }

        Spacer(modifier = Modifier.height(18.dp))

        // LISTE
        LazyColumn {

            items(movementsFirebase) { mouvement ->

                HistoryCard(item = HistoryItem(
                    emoji = if (mouvement.type == "Sortie") "🧃" else "🧴",
                    type = mouvement.type,
                    operation = mouvement.motif.ifEmpty { "Mouvement de stock" },
                    date = "12/05/2026", // À remplacer par mouvement.date formatée plus tard
                    quantity = mouvement.quantite
                )
                )
            }
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun FilterChipCard(
    text: String
) {

    Card(
        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(
            containerColor =
                if (text == "Tous")
                    Color(0xFFE7F5F3)
                else
                    Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 10.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                fontSize = 14.sp,

                color =
                    if (text == "Tous")
                        PrimaryColor
                    else
                        Color.Gray
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                imageVector =
                    Icons.Outlined.KeyboardArrowDown,

                contentDescription = null,

                modifier = Modifier.size(18.dp),

                tint =
                    if (text == "Tous")
                        PrimaryColor
                    else
                        Color.Gray
            )
        }
    }
}

@Composable
fun HistoryCard(
    item: HistoryItem
) {

    val quantityColor =
        if (item.quantity > 0)
            Color(0xFF15803D)
        else
            Color(0xFFDC2626)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // IMAGE/EMOJI
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF4F4F4)),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = item.emoji,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            // INFOS
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = item.type,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,

                    color =
                        if (item.quantity > 0)
                            Color(0xFF15803D)
                        else
                            Color(0xFFDC2626)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.operation,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.date,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            // QUANTITE
            Text(
                text =
                    if (item.quantity > 0)
                        "+${item.quantity}"
                    else
                        "${item.quantity}",

                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = quantityColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryPreview() {
    HistoryScreen()
}