package com.example.composition.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    private val _totalProducts = MutableStateFlow(250)
    val totalProducts: StateFlow<Int> = _totalProducts.asStateFlow()

    private val _lowStockProducts = MutableStateFlow(25)
    val lowStockProducts: StateFlow<Int> = _lowStockProducts.asStateFlow()

    private val _lastUpdate = MutableStateFlow("12 mai 2025")
    val lastUpdate: StateFlow<String> = _lastUpdate.asStateFlow()

    private val _lowStockItems = MutableStateFlow(
        listOf(LowStockItem("Produit A", 10, "Faible"))
    )
    val lowStockItems: StateFlow<List<LowStockItem>> = _lowStockItems.asStateFlow()
}

data class LowStockItem(
    val name: String,
    val stock: Int,
    val status: String
)