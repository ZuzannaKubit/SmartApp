package com.zuzob00l.smartapp.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zuzob00l.smartapp.navigation.AUTH_GRAPH_ROUTE
import com.zuzob00l.smartapp.navigation.Screen
import com.zuzob00l.smartapp.screens.StartScreen.StartScreen
import com.zuzob00l.smartapp.screens.loginScreen.LoginScreen
import com.zuzob00l.smartapp.screens.loginScreen.RegisterScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController)
{
    navigation(
        startDestination = Screen.Start.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.Start.route){
            StartScreen(
                navController = navController,
                onLoginClicked = { navController.navigate(Screen.Login.route) },
                onRegisterClicked = { navController.navigate(Screen.SignUp.route) })
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route){
            RegisterScreen(navController = navController) {
                
            }
        }
    }
}