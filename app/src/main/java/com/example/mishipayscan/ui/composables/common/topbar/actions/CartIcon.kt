package com.example.mishipayscan.ui.composables.common.topbar.actions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CartIcon(
    modifier: Modifier = Modifier,
    count: Int = 0
) {
    Box(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-12).dp),
            text = count.toString(),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Red
            ),
            fontWeight = FontWeight.SemiBold
        )
    }
}