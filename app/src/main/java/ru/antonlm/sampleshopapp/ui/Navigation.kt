package ru.antonlm.sampleshopapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.antonlm.catalog.CatalogEntry
import ru.antonlm.common.di.find
import ru.antonlm.product.ProductEntry
import ru.antonlm.sampleshopapp.di.LocalAppProvider

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val startDestination = destinations.find<CatalogEntry>()

    val entries = listOf(
        startDestination,
        destinations.find<ProductEntry>()
    )

    Column(Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = startDestination.featureRoute, modifier = Modifier.weight(1f)) {

            entries.forEach { entry ->
                with(entry) {
                    composable(navController, destinations)
                }
            }

        }
        BottomNavigation(navController, destinations)
    }
}
