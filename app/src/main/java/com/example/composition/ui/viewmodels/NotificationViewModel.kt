package com.example.stocknow.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.stocknow.data.models.Alertes

class NotificationViewModel : ViewModel() {
    // Liste des alertes de stock bas
    var alertes = mutableStateOf<List<Alertes>>(emptyList())

    init {
        chargerAlertes()
    }

    private fun chargerAlertes() {
        // Simulation : Produits en dessous du seuil
        alertes.value = listOf(
            Alertes(produitNom = "Huile", seuilMinimal = 5, id = "1"),
            Alertes(produitNom = "Lait", seuilMinimal = 10, id = "2")
        )
    }
}
