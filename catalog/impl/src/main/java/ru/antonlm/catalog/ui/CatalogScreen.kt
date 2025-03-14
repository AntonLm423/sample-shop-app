package ru.antonlm.catalog.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Error
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Loading
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Success
import ru.antonlm.common.extensions.isInternetAvailable
import ru.antonlm.common.ui.ErrorState
import ru.antonlm.common.ui.ErrorStateNoInternet
import ru.antonlm.common.ui.LoadingState

@Composable
fun CatalogScreen(viewModel: CatalogViewModel, onProductClick: (productId: String) -> Unit) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        viewModel.getProducts()
    }

    when (state) {
        is Success -> {

        }

        is Loading -> {
            LoadingState(modifier = Modifier.fillMaxSize())
        }

        is Error -> {
            if (LocalContext.current.isInternetAvailable()) {
                ErrorState(
                    modifier = Modifier.fillMaxSize(),

                    )
            } else {
                ErrorStateNoInternet(onButtonClick = viewModel::getProducts)
            }
        }
    }
}
