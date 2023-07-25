package com.kdroid.ecommerce.api

import com.kdroid.ecommerce.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v1/products/")
    suspend fun getProductList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<List<Product>>

}