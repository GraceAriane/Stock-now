package com.example.composition.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.composition.data.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(
        listOf(
            Product(id = "1", name = "Produit A", reference = "2306", category = "Alimentations", quantity = 10),
            Product(id = "2", name = "Produit B", reference = "1043", category = "Alimentations", quantity = 25),
            Product(id = "3", name = "Produit C", reference = "2490", category = "Électroniques", quantity = 5),
            Product(id = "4", name = "Produit D", reference = "2490", category = "Vetements", quantity = 50),
            Product(id = "5", name = "Produit E", reference = "2490", category = "Maison & Cuisine", quantity = 3)
        )
    )
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private var allProducts = _products.value
    private var currentFilter = ""
    private var currentCategory: String? = null

    fun searchProducts(query: String) {
        currentFilter = query
        applyFilters()
    }

    fun filterByCategory(category: String) {
        currentCategory = category
        applyFilters()
    }

    fun clearFilter() {
        currentCategory = null
        currentFilter = ""
        applyFilters()
    }

    fun addProduct(product: Product) {
        allProducts = allProducts + product
        applyFilters()
    }

    private fun applyFilters() {
        var filtered = allProducts
        currentCategory?.let { category ->
            filtered = filtered.filter { it.category == category }
        }
        if (currentFilter.isNotEmpty()) {
            filtered = filtered.filter {
                it.name.contains(currentFilter, ignoreCase = true) ||
                        it.reference.contains(currentFilter)
            }
        }
        _products.value = filtered
    }
}
