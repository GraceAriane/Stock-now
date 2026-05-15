package com.example.stocknow.data.utils

object FirestoreConstants {
    // Noms des Collections
    const val COLLECTION_PRODUITS = "produits"
    const val COLLECTION_MOUVEMENTS = "mouvements"
    const val COLLECTION_CATEGORIES = "categories"
    const val COLLECTION_FOURNISSEURS = "fournisseurs"
    const val COLLECTION_ALERTES = "alertes"
    const val COLLECTION_EXPORTS = "exports"
    const val COLLECTION_SETTINGS = "settings"
    const val COLLECTION_USERS = "users"

    // Noms des champs fréquents (pour éviter les erreurs dans les requêtes)
    // Utile si vous faites des filtres .whereEqualTo("type", "Entrée")
    const val FIELD_PRODUIT_ID = "produitId"
    const val FIELD_DATE = "date"
    const val FIELD_TYPE = "type"
}