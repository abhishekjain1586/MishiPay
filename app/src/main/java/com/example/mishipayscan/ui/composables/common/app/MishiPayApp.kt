package com.example.mishipayscan.ui.composables.common.app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.mishipayscan.ui.composables.common.navhost.MishiPayNavHost

@Composable
fun MishiPayApp() {
    val rootNavController = rememberNavController()

    Scaffold { _ ->
        MishiPayNavHost(
            rootNavController = rootNavController
        )
    }
}