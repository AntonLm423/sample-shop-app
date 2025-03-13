package ru.antonlm.catalog

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import ru.antonlm.common.di.Destinations
import javax.inject.Inject

class CatalogEntryImpl @Inject constructor() : CatalogEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        TODO("Not yet implemented")
    }
}