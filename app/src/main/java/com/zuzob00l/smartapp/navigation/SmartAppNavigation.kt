package com.zuzob00l.smartapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zuzob00l.smartapp.screens.StartScreen.StartScreen
import com.zuzob00l.smartapp.screens.home.HomeScreen
import com.zuzob00l.smartapp.screens.loginScreen.LoginScreen
import com.zuzob00l.smartapp.screens.loginScreen.RegisterScreen

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
            LoginScreen(navController = navController)
        }
        composable(route = SmartAppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(route = SmartAppScreens.RegisterScreen.name) {
            RegisterScreen(
                navController = navController,
                popUpScreen = { navController.navigate(SmartAppScreens.HomeScreen.name) })
        }
    }
}