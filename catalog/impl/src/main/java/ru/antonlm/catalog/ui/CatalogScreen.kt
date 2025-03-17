package ru.antonlm.catalog.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.antonlm.catalog.impl.R
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Error
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Loading
import ru.antonlm.catalog.ui.CatalogViewModel.ScreenState.Success
import ru.antonlm.common.extensions.isInternetAvailable
import ru.antonlm.common.ui.ErrorState
import ru.antonlm.common.ui.ErrorStateNoInternet
import ru.antonlm.common.ui.LoadingState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(viewModel: CatalogViewModel, onProductClick: (productId: Int) -> Unit) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getProducts()
    }

    val pullToRefreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CatalogAppBar()
        },
        content = { paddingValues ->
            PullToRefreshBox(
                modifier = Modifier.padding(paddingValues),
                isRefreshing = isRefreshing,
                onRefresh = {
                    coroutineScope.launch {
                        isRefreshing = true
                        viewModel.getProducts()
                        delay(250L)
                        isRefreshing = false
                    }
                },
                state = pullToRefreshState,
                indicator = {
                    Indicator(
                        modifier = Modifier.align(Alignment.TopCenter),
                        isRefreshing = isRefreshing,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        state = pullToRefreshState
                    )
                },
            ) {
                DisplayState(state = state, onRefresh = viewModel::getProducts, onProductClick = onProductClick)
            }
        }
    )
}

@Composable
private fun DisplayState(state: CatalogViewModel.ScreenState, onRefresh: () -> Unit, onProductClick: (productId: Int) -> Unit) {
    when (state) {
        is Success -> {
            val products = state.products
            if (products.isEmpty()) {
                EmptyState()
            } else {
                SuccessState(products = products, onProductClick = onProductClick)
            }
        }

        is Loading -> {
            LoadingState(modifier = Modifier.fillMaxSize())
        }

        is Error -> {
            if (LocalContext.current.isInternetAvailable()) {
                ErrorState(
                    modifier = Modifier.fillMaxSize(),
                    messageString = state.message,
                    buttonTextResId = ru.antonlm.common.R.string.common_retry,
                    onButtonClick = onRefresh
                )
            } else {
                ErrorStateNoInternet(onButtonClick = onRefresh)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CatalogAppBar() {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart),
            ) {
                Text(text = stringResource(R.string.catalog_title))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        modifier = Modifier
            .height(72.dp)
            .shadow(elevation = 2.dp)
    )
}