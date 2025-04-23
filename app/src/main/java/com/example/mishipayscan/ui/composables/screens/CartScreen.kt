package com.example.mishipayscan.ui.composables.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mishipayscan.R
import com.example.mishipayscan.ui.composables.common.item.CartItem
import com.example.mishipayscan.ui.composables.common.topbar.MishiPayTopBar
import com.example.mishipayscan.ui.viewmodels.CartViewModel

@Composable
fun CartScreen(
    uiState: CartViewModel.UiState,
    navigateToCheckout: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            MishiPayTopBar(
                title = stringResource(id = R.string.cart),
                onBack = onBack
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.products, key = { it.id }) { product ->
                    CartItem(product = product)
                }
            }
            Button(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                onClick = navigateToCheckout,
                enabled = uiState.products.isNotEmpty()
            ) {
                Text(
                    text = stringResource(id = R.string.checkout),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}