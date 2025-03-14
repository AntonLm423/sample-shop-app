package ru.antonlm.common.domain

import ru.antonlm.common.utils.NetworkResult

interface ProductsRepository {

    suspend fun getProducts(): NetworkResult<List<Product>>
}