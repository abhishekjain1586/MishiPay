package com.example.mishipayscan.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mishipayscan.R
import com.example.mishipayscan.ui.composables.common.item.CheckoutItem
import com.example.mishipayscan.ui.composables.common.topbar.MishiPayTopBar
import com.example.mishipayscan.ui.viewmodels.CheckoutViewModel

@Composable
fun CheckoutScreen(
    uiState: CheckoutViewModel.UiState,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            MishiPayTopBar(
                title = stringResource(id = R.string.checkout),
                onBack = onBack
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF4F8FB))
                    .padding(padding)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 16.dp),
                ) {
                    item {
                        Text(
                            modifier = Modifier.padding(vertical = 16.dp),
                            text = stringResource(id = R.string.purchase_summary),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Divider()
                    }

                    items(uiState.products, key = { it.id }) { product ->
                        CheckoutItem(
                            product = product
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .align(Alignment.BottomCenter),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(0.6f),
                        text = stringResource(id = R.string.total),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.rs, uiState.total),
                        style = MaterialTheme.typography.bodyLarge,
                    )

                    Box(
                        modifier = Modifier
                            .weight(2f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Button(
                            onClick = {  }
                        ) {
                            Text(
                                text = stringResource(id = R.string.confirm),
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }
                    }
                }
            }
        }
    }
}