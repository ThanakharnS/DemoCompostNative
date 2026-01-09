package com.thanakharn.demojetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.thanakharn.demojetpackcompose.model.Course
import com.thanakharn.demojetpackcompose.ui.theme.DemoJetPackComposeTheme
import com.thanakharn.demojetpackcompose.view.HomePage
import com.thanakharn.demojetpackcompose.viewmodel.HomeViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thanakharn.demojetpackcompose.view.DetailPage
import com.thanakharn.demojetpackcompose.view.FirstPage
import com.thanakharn.demojetpackcompose.view.PageMenu


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]

        setContent {
            DemoJetPackComposeTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Jetpack Compose")
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.DarkGray,
                                titleContentColor = Color.White
                          )
                        )
                    }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.onPrimary
                    ) {
                        //====> Start Mock Data Array
                        val dummyData = arrayListOf<Course>()
                        val dummyDetail = arrayListOf("AAA","BBB","CCC")
                        dummyData.add(Course(title = "Production-1", image = R.drawable.samsung_galaxy_s24_ultra, detail = dummyDetail))
                        dummyData.add(Course(title = "Production-2", image = R.drawable.iphone15, detail = dummyDetail))
                        dummyData.add(Course(title = "Production-3", image = R.drawable.samsung_galaxy_a55, detail = dummyDetail))
                        dummyData.add(Course(title = "Production-4", image = R.drawable.iphone16pro_max , detail = dummyDetail))
                        dummyData.add(Course(title = "Production-5", image = R.drawable.xiaomi_redmi_note13, detail = dummyDetail))
                        //====> End Mock Data Array
                        Column {
                            //====> Screen UI 1 : LazyColumn
//                            MyListDummyData(
//                                dummyData,
//                                onClick = {
//                                Toast.makeText(applicationContext, it.title, Toast.LENGTH_SHORT).show()
//                                })
                            //====> Screen UI 2 : Create MVVM Model
//                            HomePage(modifier = Modifier.padding(30.dp), homeViewModel )
                            //====> Screen UI 3 : Click Button to next Page and return firstPage
//                            NavHost(
//                                navController = navController,
//                                startDestination = "FirstPage",
//                                modifier = Modifier.weight(1f) // สำคัญมาก
//                            ) {
//                                composable("FirstPage") {
//                                    FirstPage(navController)
//                                }
//                                composable("detail") {
//                                    DetailPage(navController)
//                                }
//                            }
                            //====> Screen UI 4 : Call API Product Phone
                            PageMenu()


                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String ) {
    Column{
        Text(text = "HELLO $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //====> Mock Data Array
    val dummyData = arrayListOf<Course>()
    val dummyDetail = arrayListOf("AAA","BBB","CCC")
    dummyData.add(Course(title = "Production-1", image = R.drawable.samsung_galaxy_s24_ultra, detail = dummyDetail))
    dummyData.add(Course(title = "Production-2", image = R.drawable.iphone15, detail = dummyDetail))
    dummyData.add(Course(title = "Production-3", image = R.drawable.samsung_galaxy_a55, detail = dummyDetail))
    dummyData.add(Course(title = "Production-4", image = R.drawable.iphone16pro_max , detail = dummyDetail))
    dummyData.add(Course(title = "Production-5", image = R.drawable.xiaomi_redmi_note13, detail = dummyDetail))

    DemoJetPackComposeTheme {
        //Greeting("Android")
        //MyListDummyData(dummyData, onClick = {})
    }
}