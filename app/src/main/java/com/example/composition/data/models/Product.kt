package com.example.composition.data.models

data class Product(
    val id: String = "",
    val name: String = "",
    val reference: String = "",
    val category: String = "",
    val quantity: Int = 0,
    val alertThreshold: Int = 5,
    val isActive: Boolean = true,
    val imageUrl: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
