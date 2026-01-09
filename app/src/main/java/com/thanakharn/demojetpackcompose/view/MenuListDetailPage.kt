package com.thanakharn.demojetpackcompose.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.thanakharn.demojetpackcompose.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuListDetailPage(
    navController: NavController,
    viewModel: ProductViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {
    val products by viewModel.products.collectAsState()

    // เรียก API ตอนเข้า Screen ครั้งแรก
    LaunchedEffect(Unit) {
        viewModel.fetchProducts1()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(products) { product ->
            Card(
                modifier = Modifier.fillMaxWidth()
                    .clickable{
                        // บันทึก product ที่เลือก
                        viewModel.selectProduct(product)
                        // ไปหน้า detail
                        navController.navigate("product_detail")
                    },
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    AsyncImage(
                        model = product.image,
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(product.name, fontWeight = FontWeight.Bold , fontSize = 24.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("ราคาเครื่อง : "+product.price, fontSize = 16.sp)
                }
            }
        }
    }
}

