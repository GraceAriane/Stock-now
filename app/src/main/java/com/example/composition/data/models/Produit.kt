package com.example.composition.data.models

data class Produit(
    val id: String = "",
    val nom: String = "",
    val description: String = "",
    val prix: Double = 0.0,
    val quantiteStock: Int = 0,
    val categorieId: String = "",
    val imageUrl: String = ""
)
