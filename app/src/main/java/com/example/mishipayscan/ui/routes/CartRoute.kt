package com.example.mishipayscan.ui.routes

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mishipayscan.ui.composables.screens.CartScreen
import com.example.mishipayscan.ui.viewmodels.CartViewModel
import kotlinx.serialization.Serializable

@Serializable
sealed class CartRoute : IRoute {
    @Serializable
    data object Cart : CartRoute()
}

fun NavGraphBuilder.cartDestination(
    navigateToCheckout: () -> Unit,
    onBack: () -> Unit
) {
    composable<CartRoute.Cart> {
        val viewModel: CartViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        CartScreen(
            uiState = uiState,
            navigateToCheckout = navigateToCheckout,
            onBack = onBack
        )
    }
}