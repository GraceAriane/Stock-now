package com.example.composition.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composition.data.models.Alertes

class NotificationViewModel : ViewModel() {
    var alertes = mutableStateOf<List<Alertes>>(emptyList())

    init {
        chargerAlertes()
    }

    private fun chargerAlertes() {
        alertes.value = listOf(
            Alertes(produitNom = "Huile", seuilMinimal = 5, id = "1"),
            Alertes(produitNom = "Lait", seuilMinimal = 10, id = "2")
        )
    }
}
