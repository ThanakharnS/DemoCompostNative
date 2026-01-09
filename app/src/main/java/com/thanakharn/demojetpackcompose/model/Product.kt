package com.thanakharn.demojetpackcompose.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val image: String,
    val amount: Int
)

// ProductResponse.kt
data class ProductResponse(
    val totalCount: Int,
    val status: String,
    val products: List<Product>
)