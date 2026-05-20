package com.example.stocknow.data.models

data class UserSettings(
    val userId: String = "",
    val notificationsActivees: Boolean = true,
    val langue: String = "Français",
    val modeSombre: Boolean = false,
    val devise: String = "FCFA"
)