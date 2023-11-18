package com.zuzob00l.smartapp.navigation

enum class SmartAppScreens() {
    StartScreen,
    LoginScreen,
    HomeScreen,
    RegisterScreen;

    companion object {
        fun fromRoute(route: String?): SmartAppScreens = when (route?.substringBefore("/")) {
            StartScreen.name -> StartScreen
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("route $route is not recognized")
        }
    }
}
 
