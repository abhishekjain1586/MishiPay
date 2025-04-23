package com.example.mishipayscan.ui.routes

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mishipayscan.ui.composables.screens.CheckoutScreen
import com.example.mishipayscan.ui.viewmodels.CheckoutViewModel
import kotlinx.serialization.Serializable

@Serializable
sealed class CheckoutRoute : IRoute {
    @Serializable
    data object Checkout : CheckoutRoute()
}

fun NavGraphBuilder.checkoutDestination(onBack: () -> Unit) {
    composable<CheckoutRoute.Checkout> {
        val viewModel: CheckoutViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        CheckoutScreen(
            uiState = uiState,
            onBack = onBack
        )
    }
}