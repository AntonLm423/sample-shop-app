package ru.antonlm.product

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import ru.antonlm.common.di.Destinations
import ru.antonlm.common.di.LocalCommonProvider
import ru.antonlm.common.di.injectedViewModel
import ru.antonlm.data.LocalDataProvider
import ru.antonlm.product.di.DaggerProductComponent
import ru.antonlm.product.ui.ProductScreen
import javax.inject.Inject

class ProductEntryImpl @Inject constructor() : ProductEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val dataProvider = LocalDataProvider.current
        val commonProvider = LocalCommonProvider.current

         val productViewModel = injectedViewModel {
            DaggerProductComponent.builder()
                .dataProvider(dataProvider)
                .commonProvider(commonProvider)
                .build()
                .viewModel
        }

        ProductScreen(productViewModel, "123")
    }
}