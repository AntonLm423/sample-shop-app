package ru.antonlm.sampleshopapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.antonlm.catalog.CatalogEntry
import ru.antonlm.common.di.find
import ru.antonlm.sampleshopapp.di.LocalAppProvider

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val catalog = destinations.find<CatalogEntry>()

    Column (Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = catalog.featureRoute, modifier = Modifier.weight(1f)) {
            with(catalog) {
                composable(navController, destinations)
            }
        }
        BottomNavigation(navController, destinations)
    }
}
