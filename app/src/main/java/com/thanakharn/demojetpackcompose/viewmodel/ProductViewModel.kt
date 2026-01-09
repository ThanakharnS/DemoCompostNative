package com.thanakharn.demojetpackcompose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.thanakharn.demojetpackcompose.api.RetrofitClient
import com.thanakharn.demojetpackcompose.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    // ตัวแปรเก็บ Product ที่ถูกเลือก
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }

    private fun fixImageUrl(url: String): String {
        return url.replace(
            "localhost",
            "192.168.1.103"
        )
    }


    fun fetchProducts1() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("API_CALL", "Start call API")
                val response = RetrofitClient.apiService.getProducts()

                // แก้ URL รูปก่อนส่งไป UI
                val fixedProducts = response.products.map { product ->
                    product.copy(
                        image = fixImageUrl(product.image)
                    )
                }

                Log.d("API_CALL", "Success Product = $fixedProducts")
                _products.value = fixedProducts


//                Log.d("API_CALL", "Success Product = ${response.products}")
//                _products.value = response.products
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("API_CALL", "Error", e)
            }

        }

    }


}