package ru.antonlm.data.remote

import retrofit2.Response
import retrofit2.http.GET
import ru.antonlm.common.utils.NetworkResult
import ru.antonlm.data.remote.model.ProductsResponse

interface ApiService {

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    @GET("products")
    suspend fun getProducts(): NetworkResult<ProductsResponse>
}