package com.thanakharn.demojetpackcompose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thanakharn.demojetpackcompose.viewmodel.HomeViewModel


@Composable
fun HomePage(
    modifier: Modifier = Modifier ,
    viewModel: HomeViewModel
) {
    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(
         modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            viewModel.getUserData()
        }) {
              Text("GET DATA")
        }

        if (isLoading.value == true){
            CircularProgressIndicator()
        } else{
            //===> get value Name is show
            userData.value?.name?.let{
                Text(text = "NAME IS : $it")
            }
            //===> get value Age is show
            userData.value?.age?.let{
                Text(text = "AGE IS : $it")
            }
        }





    }



}