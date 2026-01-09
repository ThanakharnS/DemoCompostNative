package com.thanakharn.demojetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thanakharn.demojetpackcompose.model.Course


@Composable
fun MyListDummyData(course: List<Course> , onClick: (Course)-> Unit){
    LazyColumn {
        items(course){
            Surface(
                modifier = Modifier.clickable{
                    onClick(it)
            }){
                ListProduct(
                    course = it,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}