package ru.antonlm.catalog

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import ru.antonlm.catalog.di.DaggerCatalogComponent
import ru.antonlm.catalog.ui.CatalogScreen
import ru.antonlm.common.di.Destinations
import ru.antonlm.common.di.LocalCommonProvider
import ru.antonlm.common.di.injectedViewModel
import ru.antonlm.data.LocalDataProvider
import javax.inject.Inject

class CatalogEntryImpl @Inject constructor() : CatalogEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val dataProvider = LocalDataProvider.current
        val commonProvider = LocalCommonProvider.current
        val catalogViewModel = injectedViewModel {
            DaggerCatalogComponent.builder()
                .dataProvider(dataProvider)
                .commonProvider(commonProvider)
                .build()
                .viewModel
        }

        CatalogScreen(viewModel = catalogViewModel, onProductClick = {})
    }
}