package ru.antonlm.data.remote

import retrofit2.http.GET
import ru.antonlm.common.domain.Product
import ru.antonlm.common.utils.NetworkResult

interface ApiService {

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    @GET("products")
    suspend fun getProducts(): NetworkResult<List<Product>>
}