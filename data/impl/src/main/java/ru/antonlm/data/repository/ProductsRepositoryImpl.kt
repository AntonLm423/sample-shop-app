package ru.antonlm.data.repository

import ru.antonlm.common.domain.Product
import ru.antonlm.common.domain.ProductsRepository
import ru.antonlm.common.utils.NetworkResult
import ru.antonlm.data.remote.ApiService
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {

    override suspend fun getProducts(): NetworkResult<List<Product>> {
        return apiService.getProducts()
    }
}
