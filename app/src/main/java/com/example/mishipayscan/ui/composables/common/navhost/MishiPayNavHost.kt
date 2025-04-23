package com.example.mishipayscan.ui.composables.common.navhost

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mishipayscan.ui.routes.CartRoute
import com.example.mishipayscan.ui.routes.CheckoutRoute
import com.example.mishipayscan.ui.routes.HomeRoute
import com.example.mishipayscan.ui.routes.cartDestination
import com.example.mishipayscan.ui.routes.checkoutDestination
import com.example.mishipayscan.ui.routes.homeDestination
import com.example.mishipayscan.ui.routes.scanDestination

@Composable
fun MishiPayNavHost(
    rootNavController: NavHostController
) {
    NavHost(
        navController = rootNavController,
        startDestination = HomeRoute.Home,
        enterTransition = { slideInHorizontally(animationSpec = tween(300)) { it } },
        exitTransition = { slideOutHorizontally(animationSpec = tween(300)) { -it } },
        popEnterTransition = { slideInHorizontally(animationSpec = tween(300)) { -it } },
        popExitTransition = { slideOutHorizontally(animationSpec = tween(300)) { it } },
    ) {
        homeDestination {
            rootNavController.navigate(CartRoute.Cart)
        }
        scanDestination()
        cartDestination(
            navigateToCheckout = { rootNavController.navigate(CheckoutRoute.Checkout) },
            onBack = { rootNavController.popBackStack() }
        )
        checkoutDestination {
            rootNavController.popBackStack()
        }
    }
}