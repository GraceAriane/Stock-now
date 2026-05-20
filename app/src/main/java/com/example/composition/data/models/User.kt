package com.example.stocknow.data.models

data class User(
    val uid: String = "",
    val nom: String = "",
    val email: String = "",
    val role: String = "employé" // "admin" ou "employé"
)