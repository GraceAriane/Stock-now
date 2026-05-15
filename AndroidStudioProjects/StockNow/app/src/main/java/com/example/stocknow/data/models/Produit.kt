package com.example.stocknow.data.models

data class Produit(
    val id: String = "",
    val nom: String = "",
    val categorie: String = "",
    val prix: Double = 0.0,
    val stockQuantite: Int = 0,
    val imageUrl: String = ""
)