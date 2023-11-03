package com.zuzob00l.smartapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zuzob00l.smartapp.screens.StartScreen.StartScreen

@Composable
fun SmartAppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SmartAppScreens.StartScreen.name)
    {
       composable(route = SmartAppScreens.StartScreen.name) {
           StartScreen(navController = navController)
       }

        composable(route = SmartAppScreens.LoginScreen.name) {

        }
        composable(route = SmartAppScreens.HomeScreen.name) {

        }
    }
}