package com.example.composition.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import com.example.composition.ui.theme.data.Aliment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AlimentationsViewModel : ViewModel() {
    private val _aliments = MutableStateFlow<List<Aliment>>(
        listOf(
            Aliment("1", "Produit A", "2306", "Alimentations"),
            Aliment("2", "Produit B", "1043", "Alimentations"),
            Aliment("3", "Produit C", "2490", "Alimentations"),
            Aliment("4", "Produit D", "2490", "Alimentations"),
            Aliment("5", "Produit E", "2490", "Alimentations")
        )
    )
    val aliments: StateFlow<List<Aliment>> = _aliments.asStateFlow()
}