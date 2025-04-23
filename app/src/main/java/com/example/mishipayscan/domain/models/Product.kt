package com.example.mishipayscan.domain.models

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val imagePath: String,
    val quantity: Int
)
