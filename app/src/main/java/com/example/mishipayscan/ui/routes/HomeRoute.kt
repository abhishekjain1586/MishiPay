package com.example.mishipayscan.ui.routes

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mishipayscan.ui.composables.screens.HomeScreen
import com.example.mishipayscan.ui.viewmodels.HomeViewModel
import kotlinx.serialization.Serializable

@Serializable
sealed class HomeRoute : IRoute {
    @Serializable
    data object Home : HomeRoute()
}

fun NavGraphBuilder.homeDestination(navigateToCart: () -> Unit) {
    composable<HomeRoute.Home> {
        val viewModel: HomeViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        val event by viewModel.event.collectAsState(
            initial = HomeViewModel.Event.Scanning
        )

        HomeScreen(
            uiState = uiState,
            event = event,
            onAddToCart = viewModel::onAddToCart,
            onScanError = viewModel::onScanError,
            navigateToCart = navigateToCart
        )
    }
}