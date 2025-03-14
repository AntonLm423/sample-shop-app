package ru.antonlm.catalog.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.antonlm.common.di.CommonModule.IO
import ru.antonlm.common.domain.Product
import ru.antonlm.common.domain.ProductsRepository
import ru.antonlm.common.utils.onFailure
import ru.antonlm.common.utils.onSuccess
import javax.inject.Inject
import javax.inject.Named

class CatalogViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    @Named(IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getProducts() {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                _uiState.emit(ScreenState.Loading)

                productsRepository.getProducts()
                    .onSuccess { products ->
                        _uiState.emit(ScreenState.Success(products))
                    }.onFailure { message ->
                        _uiState.emit(ScreenState.Error(message))
                    }
            }
        }
    }

    sealed interface ScreenState {

        data class Success(val products: List<Product>) : ScreenState
        data object Loading : ScreenState
        data class Error(val message: String?) : ScreenState
    }
}
