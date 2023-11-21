package com.zuzob00l.smartapp.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"

sealed class Screen(val route: String) {
    object Home: Screen(route = "HomeScreen")
    object Login: Screen(route = "SignInScreen")
    object SignUp: Screen(route = "SignUpScreen")
    object Start: Screen(route = "StartScreen")
}
 
