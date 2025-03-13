package ru.antonlm.data.repository

import ru.antonlm.common.domain.Product
import ru.antonlm.common.domain.ProductsRepository
import ru.antonlm.common.utils.NetworkResult
import ru.antonlm.common.utils.map
import ru.antonlm.common.utils.onSuccess
import ru.antonlm.data.remote.ApiService
import ru.antonlm.data.remote.model.ProductsResponse
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {

    override suspend fun getProducts(): NetworkResult<ArrayList<Product>> {
        return apiService.getProducts().map { it }
    }
}
