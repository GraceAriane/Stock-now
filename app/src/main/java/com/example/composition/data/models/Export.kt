package com.example.stocknow.data.models

data class Export(
    val id: String = "",
    val dateExport: Long = System.currentTimeMillis(),
    val typeFormat: String = "PDF", // "PDF" ou "Excel"
    val utilisateurId: String = "", // Qui a fait l'export
    val urlFichier: String = "" // Lien vers le fichier dans Firebase Storage
)