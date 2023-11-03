package com.zuzob00l.smartapp.navigation

enum class SmartAppScreens() {
    StartScreen,
    LoginScreen,
    HomeScreen;

    companion object {
        fun fromRoute(route: String?): SmartAppScreens = when (route?.substringBefore("/")) {
            StartScreen.name -> StartScreen
            LoginScreen.name -> LoginScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("route $route is not recognized")
        }
    }
}
 
