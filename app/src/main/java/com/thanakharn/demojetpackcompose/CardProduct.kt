package com.thanakharn.demojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thanakharn.demojetpackcompose.model.Course


@Composable
fun ListProduct(
    course: Course,
    modifier: Modifier = Modifier
){
    Surface (
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 16.dp,
        modifier = modifier
    ){
        Column {
            Image(
                painter = painterResource(course.image),
                contentDescription = "Description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    course.title,
                    style = MaterialTheme.typography.headlineMedium
                )

                for (item in course.detail){
                    Text(" ํ $item")
                }
            }
        }
    }

}