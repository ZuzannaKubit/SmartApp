package com.zuzob00l.smartapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zuzob00l.smartapp.navigation.HOME_GRAPH_ROUTE
import com.zuzob00l.smartapp.navigation.Screen
import com.zuzob00l.smartapp.screens.home.HomeScreen


fun NavGraphBuilder.homeNavGraph(navController: NavHostController) 
{
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
    }
}