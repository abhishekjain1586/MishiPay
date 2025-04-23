package com.example.mishipayscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mishipayscan.domain.models.Product
import com.example.mishipayscan.domain.usecase.GetCartProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val getCartProductsUseCase: GetCartProductsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = getCartProductsUseCase.invoke()
            _uiState.update {
                it.copy(
                    products = products,
                    total = getTotalAmount(products)
                )
            }
        }
    }

    private fun getTotalAmount(products: List<Product>): Double {
        return products.sumOf { it.quantity * it.price }
    }

    data class UiState(
        val products: List<Product> = listOf(),
        val total: Double = 0.00
    )
}