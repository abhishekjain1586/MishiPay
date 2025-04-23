package com.example.mishipayscan.ui.composables.common.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mishipayscan.R
import com.example.mishipayscan.domain.models.Product

@Composable
fun CheckoutItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                modifier = Modifier.weight(3f),
                text = product.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.qty, product.quantity.toString()),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.rs, product.price.toString()),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Divider()
    }
}