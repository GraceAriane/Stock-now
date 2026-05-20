package com.example.composition.data.models

data class Export(
    val id: String = "",
    val nomFichier: String = "",
    val format: String = "", // PDF, Excel
    val dateExport: Long = System.currentTimeMillis()
)
