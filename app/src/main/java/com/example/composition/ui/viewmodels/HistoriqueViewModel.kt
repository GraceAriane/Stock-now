package com.example.composition.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composition.data.models.Movement
import androidx.compose.runtime.State

class HistoriqueViewModel : ViewModel() {
    private val _mouvements = mutableStateOf<List<Movement>>(emptyList())
    val mouvements: State<List<Movement>> = _mouvements

    var searchQuery = mutableStateOf("")

    init {
        chargerHistorique()
    }

    private fun chargerHistorique() {
        // Simulation des données
        _mouvements.value = listOf(
            Movement(type = "Sortie", produitNom = "Huile", quantite = 30, date = System.currentTimeMillis()),
            Movement(type = "Entrée", produitNom = "Savon", quantite = 50, date = System.currentTimeMillis()),
            Movement(type = "Entrée", produitNom = "Riz", quantite = 100, date = System.currentTimeMillis())
        )
    }
}
