package com.example.stocknow.data.models

data class Categorie(
    val id: String = "",
    val nom: String = "", // ex: "Huiles", "Savons", "Conserves"
    val icone: String = "" // stocker le nom d'une icône ou une URL
)