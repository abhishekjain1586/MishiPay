package com.example.mishipayscan.domain.usecase

import com.example.mishipayscan.domain.models.Product
import com.example.mishipayscan.domain.repository.ICartRepository
import javax.inject.Inject

class GetCartProductsUseCase @Inject constructor(
    private val cartRepository: ICartRepository
) {

    suspend operator fun invoke(): List<Product> {
        return cartRepository.getCartProducts()
    }
}