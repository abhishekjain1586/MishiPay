package com.example.mishipayscan.ui.composables.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mishipayscan.R
import com.example.mishipayscan.ui.composables.common.topbar.MishiPayTopBar
import com.example.mishipayscan.ui.composables.common.topbar.actions.CartIcon
import com.example.mishipayscan.ui.viewmodels.HomeViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun HomeScreen(
    uiState: HomeViewModel.UiState,
    event: HomeViewModel.Event,
    onAddToCart: (String) -> Unit,
    onScanError: () -> Unit,
    navigateToCart: () -> Unit
) {
    val launcher = rememberLauncherForActivityResult(contract = ScanContract()) { result ->
        result.contents?.let { onAddToCart(it) } ?: onScanError()
    }

    LaunchedEffect(key1 = event) {
        when (event) {
            is HomeViewModel.Event.Scanning -> {}
            is HomeViewModel.Event.ScanError -> {}
        }
    }

    Scaffold(
        topBar = {
            MishiPayTopBar(
                hasNavigationIcon = false,
                actionItems = {
                    CartIcon(
                        modifier = Modifier
                            .clickable { navigateToCart() }
                            .padding(16.dp),
                        count = uiState.cartCount
                    )
                }
            )
        }
    ) { _ ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                        launcher.launch(
                            ScanOptions().apply {
                                setPrompt("Scan a barcode")
                                setBeepEnabled(false)
                                setOrientationLocked(false)
                                setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES)
                            }
                        )
                    }
                    .padding(16.dp)
                    .size(80.dp),
                imageVector = Icons.Filled.QrCodeScanner,
                contentDescription = stringResource(id = R.string.scan)
            )

            Text(
                text = stringResource(id = R.string.scan_item_and_add_to_cart),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}