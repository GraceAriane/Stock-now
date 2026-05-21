package com.example.composition.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composition.R
import com.example.composition.ui.theme.CompositionTheme

data class Aliment(
    val nom: String,
    val code: String,
    val image: Int
)

@Composable
fun AlimentationsScreen(navController: NavController) {
    val aliments = listOf(
        Aliment(nom = "Produit A", code = "2306", image = R.drawable.ic_product1),
        Aliment(nom = "Produit B", code = "1043", image = R.drawable.biscuit),
        Aliment(nom = "Produit C", code = "2490", image = R.drawable.electronic),
        Aliment(nom = "Produit D", code = "2490", image = R.drawable.beauty),
        Aliment(nom = "Produit E", code = "2490", image = R.drawable.clothes)
    )

    var searchQuery by remember { mutableStateOf("") }

    val filteredAliments = if (searchQuery.isEmpty()) {
        aliments
    } else {
        aliments.filter { it.nom.contains(searchQuery, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Retour", tint = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Alimentations", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1C1C1C))
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text(text = "Rechercher.....", color = Color.Gray) },
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { searchQuery = "" }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.DarkGray, modifier = Modifier.size(30.dp))
                }
                Text(text = "Tout vider", color = Color.Gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(filteredAliments) { aliment ->
                var expanded by remember { mutableStateOf(false) }

                Card(
                    modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = aliment.image),
                                contentDescription = aliment.nom,
                                modifier = Modifier.size(62.dp).clip(RoundedCornerShape(12.dp))
                            )
                            Spacer(modifier = Modifier.width(14.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = aliment.nom, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color(0xFF333333))
                            }
                            Text(text = aliment.code, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                        }

                        if (expanded) {
                            HorizontalDivider(color = Color(0xFFEAEAEA))
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TextButton(onClick = { }) {
                                    Text(text = "Modifier", color = Color(0xFF01596D))
                                }
                                TextButton(onClick = { }) {
                                    Text(text = "Supprimer", color = Color.Red)
                                }
                            }
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlimentationsScreenPreview() {
    CompositionTheme {
        AlimentationsScreen(rememberNavController())
    }
}
