package com.thanakharn.demojetpackcompose.api

import com.thanakharn.demojetpackcompose.model.ProductResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api/products")
    suspend fun getProducts(): ProductResponse
}