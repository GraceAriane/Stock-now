package com.example.composition.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import com.example.composition.ui.theme.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddEditProductViewModel : ViewModel() {
    private val _saveResult = MutableStateFlow<Boolean?>(null)
    val saveResult: StateFlow<Boolean?> = _saveResult.asStateFlow()

    fun saveProduct(
        name: String,
        alertThreshold: Int,
        quantity: Int,
        category: String,
        isActive: Boolean,
        imageUrl: String?
    ): Product? {
        if (name.isEmpty()) return null

        val newProduct = Product(
            id = "",
            name = name,
            reference = (1000..9999).random().toString(),
            category = category,
            quantity = quantity,
            alertThreshold = alertThreshold,
            isActive = isActive,
            imageUrl = imageUrl,
            createdAt = System.currentTimeMillis()
        )

        _saveResult.value = true
        return newProduct
    }

    fun clearResult() {
        _saveResult.value = null
    }
}