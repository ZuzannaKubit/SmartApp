 package com.zuzob00l.smartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zuzob00l.smartapp.navigation.nav_graph.SetupNavGraph
import com.zuzob00l.smartapp.screens.loginScreen.SignInViewModel
import com.zuzob00l.smartapp.ui.theme.SmartAppTheme
import dagger.hilt.android.AndroidEntryPoint
 @AndroidEntryPoint
class MainActivity : ComponentActivity() {

     private lateinit var navController: NavHostController
     private val SignInViewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartAppTheme {

                navController = rememberNavController()
                SmartApp(navController)
            }
        }
    }
}
 @Composable
 fun SmartApp(navController: NavHostController)
 {
     Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background
     ) {
         Column(
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally)
         {
             SetupNavGraph(navController = navController)
         }
     }
 }
