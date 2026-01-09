package com.thanakharn.demojetpackcompose.view

import android.R
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thanakharn.demojetpackcompose.model.MenuListItem
import com.thanakharn.demojetpackcompose.viewmodel.ProductViewModel


@Composable
fun MenuListHomePage(
    navController: NavHostController,
    viewModel: ProductViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    //=====> Mock Data Menu
    val menuList = listOf(
        MenuListItem("Menu 1", "Call API Service Product Phone", "detail"),
        MenuListItem("Menu 2", "เมนูอื่น ๆ", "Page"),
        MenuListItem("Menu 3", "เมนูอื่น ๆ", ""),
        MenuListItem("Menu 4", "เมนูอื่น ๆ", "")
//        MenuListItem("Menu 5", "เมนูอื่น ๆ", ""),
//        MenuListItem("Menu 6", "เมนูอื่น ๆ", ""),
//        MenuListItem("Menu 7", "เมนูอื่น ๆ", ""),
//        MenuListItem("Menu 8", "เมนูอื่น ๆ", ""),
//        MenuListItem("Menu 9", "เมนูอื่น ๆ", ""),
//        MenuListItem("Menu 10", "เมนูอื่น ๆ", "")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(menuList) { menu ->
            MenuCard(
                title = menu.title,
                description = menu.description,
        //===========> Action Click
                onClick = {

                    Log.d("=====> Log Data menu.title ", menu.title)

                    if (menu.route == "detail") {
                        viewModel.fetchProducts1()
                        navController.navigate(menu.route)
                    }

                    if (menu.route == "Page") {
                        navController.navigate(menu.route)
                    }
                }
            )
        }
    }
}



@Composable
fun MenuCard(
    title: String,
    description: String,
    onClick: () -> Unit ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}