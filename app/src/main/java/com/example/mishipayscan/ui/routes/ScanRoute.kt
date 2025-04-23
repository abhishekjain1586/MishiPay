package com.example.mishipayscan.ui.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mishipayscan.ui.composables.screens.ScanScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class ScanRoute : IRoute {
    @Serializable
    data object Scan : ScanRoute()
}

fun NavGraphBuilder.scanDestination() {
    composable<ScanRoute.Scan> {
        ScanScreen()
    }
}