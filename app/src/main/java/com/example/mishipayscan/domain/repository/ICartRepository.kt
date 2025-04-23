package com.example.mishipayscan.domain.repository

import com.example.mishipayscan.domain.models.Product

interface ICartRepository {
    suspend fun addToCart(result: String): List<Product>
    suspend fun getCartProducts(): List<Product>
}