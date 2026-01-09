package com.thanakharn.demojetpackcompose.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.thanakharn.demojetpackcompose.viewmodel.ProductViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailPage(
    navController: NavController,
    viewModel: ProductViewModel
){
    val product by viewModel.selectedProduct.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("รายละเอียดสินค้า") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = { paddingValues ->

            product?.let {
                Column(
                    modifier = Modifier
                        .padding(paddingValues) // ให้ไม่ทับ TopAppBar
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // กำหนดทั้งหมดใน Column
                ) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    // ชื่อสินค้าอยู่กึ่งกลาง
                    Text(
                        text = it.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // ข้อมูลอื่น ๆ จะชิดซ้ายถ้าใช้ Box หรือ Modifier.fillMaxWidth()
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("ผลิตภัณฑ์ของ: ${it.brand}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text("ราคาเครื่อง: ${it.price}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text("จำนวนสินค้า: ${it.amount}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }
            } ?: run {
                Text(
                    "ไม่พบข้อมูลสินค้า",
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp
                )
            }
        }
    )



//    product?.let {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//
//            AsyncImage(
//                model = it.image,
//                contentDescription = it.name,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//            )
//            Spacer(modifier = Modifier.height(32.dp))
//            Text(
//                text = it.name,
//                fontWeight = FontWeight.Bold,
//                fontSize = 28.sp,
//                modifier = Modifier.align(Alignment.CenterHorizontally) // สำคัญ!
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text("ผลิตภัณฑ์ของ: ${it.brand}",fontWeight = FontWeight.Bold, fontSize = 20.sp)
//            Text("ราคาเครื่อง: ${it.price}",fontWeight = FontWeight.Bold, fontSize = 20.sp)
//            Text("จำนวนสินค้า: ${it.amount}",fontWeight = FontWeight.Bold, fontSize = 20.sp)
//        }
//
//    } ?: run {
//        Text("ไม่พบข้อมูลสินค้า", modifier = Modifier.padding(16.dp))
//    }





}