package com.example.mishipayscan.ui.composables.common.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MishiPayTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    hasNavigationIcon: Boolean = true,
    actionItems: @Composable (() -> Unit)? = null,
    onBack: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            title?.let {
                Text(text = title)
            }
        },
        navigationIcon = {
            if (hasNavigationIcon) {
                Icon(
                    modifier = Modifier
                        .clickable { onBack?.invoke() }
                        .padding(16.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            actionItems?.let { ActionItems ->
                ActionItems()
            }
        }
    )
}