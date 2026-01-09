package com.thanakharn.demojetpackcompose.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thanakharn.demojetpackcompose.viewmodel.ProductViewModel


@Composable
fun PageMenu() {
    // Controls page UI
    val navController = rememberNavController()
    val viewModel: ProductViewModel = androidx.lifecycle.viewmodel.compose.viewModel()


    NavHost(
        navController = navController,
        startDestination = "Menu List"
    ){
        composable("Menu List") {
            MenuListHomePage(navController = navController, viewModel = viewModel)
        }

        composable("detail") {
            MenuListDetailPage(navController = navController, viewModel = viewModel)
        }

        composable("Page") {
            Page()
        }

        composable("product_detail") {
            ProductDetailPage(navController = navController,viewModel = viewModel)
        }
    }
}