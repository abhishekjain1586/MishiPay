package com.example.mishipayscan.data.repository

import android.util.Log
import com.example.mishipayscan.domain.models.Product
import com.example.mishipayscan.domain.repository.ICartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    //private val cartDataSource: CartDataSource
): ICartRepository {

    private var cartProducts = mutableListOf<Product>()

    override suspend fun addToCart(result: String): List<Product> {
        val newProduct: Product = getRandomProduct()
        Log.d("testingggg", " ${this.hashCode()}// ${newProduct.id} //  ${newProduct.title}")

        val existingProduct = cartProducts.find { it.id == newProduct.id }
        existingProduct?.let {
            val index = cartProducts.indexOf(it)
            cartProducts[index] = it.copy(quantity = it.quantity + 1)
        } ?: cartProducts.add(newProduct)

        return cartProducts
    }

    override suspend fun getCartProducts(): List<Product> {
        return cartProducts
    }

    private fun getRandomProduct(): Product {
        val randomId = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).random()
        return products.first { randomId == it.id }
    }
}

val products = listOf(
    Product(
        id = 1,
        title = "Fruit 1",
        price = 100.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 2,
        title = "Fruit 2",
        price = 300.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 3,
        title = "Fruit 3",
        price = 59.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 4,
        title = "Fruit 4",
        price = 100.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 5,
        title = "Fruit 5",
        price = 300.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 6,
        title = "Fruit 6",
        price = 59.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 7,
        title = "Fruit 7",
        price = 100.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 8,
        title = "Fruit 8",
        price = 300.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 9,
        title = "Fruit 9",
        price = 59.00,
        imagePath = "",
        quantity = 1
    ),
    Product(
        id = 10,
        title = "Fruit 10",
        price = 59.00,
        imagePath = "",
        quantity = 1
    )
)