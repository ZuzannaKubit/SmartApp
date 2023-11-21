package com.zuzob00l.smartapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zuzob00l.smartapp.navigation.AUTH_GRAPH_ROUTE

@Composable
fun SetupNavGraph(navController: NavHostController)
{
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE) {

        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}