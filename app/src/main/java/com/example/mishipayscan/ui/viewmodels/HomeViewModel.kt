package com.example.mishipayscan.ui.viewmodels

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mishipayscan.domain.usecase.AddToCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    fun onAddToCart(result: String) {
        if (result.isNotEmpty()) {
            viewModelScope.launch {
                val products = addToCartUseCase.invoke(result)

                var count = 0;
                products.forEach { product ->
                    count += product.quantity
                }

                _uiState.update {
                    it.copy(
                        cartCount = count
                    )
                }
            }
        }
    }

    fun onScanError() {

    }

    data class UiState(
        val cartCount: Int = 0
    )

    sealed class Event {
        data object Scanning : Event()
        data class ScanError(
            @StringRes val errorMsg: Int? = null
        ): Event()
    }
}