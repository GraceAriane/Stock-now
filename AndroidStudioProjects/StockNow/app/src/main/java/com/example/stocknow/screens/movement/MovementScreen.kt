package com.example.stocknow.screens.movement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stocknow.ui.viewmodels.MovementViewModel

private val PrimaryColor = Color(0xFF0F766E)

@Composable
fun MovementScreen(viewModel: MovementViewModel = viewModel()) {

    var quantity by remember { mutableStateOf("10") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        // HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceBetween,
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text = "Mouvements",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = { }
            ) {

                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CARD FORMULAIRE
        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(24.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {

                // TYPE (Lié au ViewModel)
                Text(
                    text = "Type",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.typeSelectionne.value,
                    onValueChange = { viewModel.typeSelectionne.value = it },

                    modifier = Modifier.fillMaxWidth(),

                    trailingIcon = {

                        Icon(
                            imageVector =
                                Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null
                        )
                    },

                    shape = RoundedCornerShape(14.dp),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor =
                            Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                // PRODUITS
                Text(
                    text = "Produits",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),

                    colors = CardDefaults.cardColors(
                        containerColor =
                            Color(0xFFF9F9F9)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),

                        verticalAlignment =
                            Alignment.CenterVertically,

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Row(
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text = "🧴",
                                fontSize = 28.sp
                            )

                            Spacer(
                                modifier =
                                    Modifier.width(12.dp)
                            )

                            Text(text = viewModel.nomProduit.value.ifEmpty { "huile" }, fontSize = 16.sp)
                        }

                        Icon(
                            imageVector =
                                Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // QUANTITE
                Text(
                    text = "Quantité",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = quantity,

                    onValueChange = {
                        quantity = it
                    },

                    modifier = Modifier.fillMaxWidth(),

                    trailingIcon = {

                        Icon(
                            imageVector =
                                Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null
                        )
                    },

                    shape = RoundedCornerShape(14.dp),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor =
                            Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                // DATE
                Text(
                    text = "Date",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "24 avr. 2024",
                    onValueChange = { },

                    modifier = Modifier.fillMaxWidth(),

                    trailingIcon = {

                        Icon(
                            imageVector =
                                Icons.Outlined.CalendarMonth,
                            contentDescription = null
                        )
                    },

                    shape = RoundedCornerShape(14.dp),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor =
                            Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.height(28.dp))

                // BOUTON
                Button(
                    onClick = { },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),

                    shape = RoundedCornerShape(16.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    )
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Save,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Enregistrer",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovementPreview() {
    MovementScreen()
}