package com.example.composition.data.models

data class Alertes(
    val id: String = "",
    val produitId: String = "",
    val produitNom: String = "",
    val seuilMinimal: Int = 5, // Seuil à partir duquel on alerte
    val estActif: Boolean = true
)
