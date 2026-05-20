package com.example.stocknow.data.models

data class Movement(
    val id: String = "",
    val produitId: String = "",
    val produitNom: String = "",
    val type: String = "", // "Entrée" ou "Sortie"
    val quantite: Int = 0,
    val date: Long = System.currentTimeMillis(), // Timestamp actuel par défaut
    val motif: String = "" // Ex: "Vente", "Réapprovisionnement"
)