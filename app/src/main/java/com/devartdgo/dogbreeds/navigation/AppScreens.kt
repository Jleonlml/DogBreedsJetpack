package com.devartdgo.dogbreeds.navigation

enum class AppScreens {
    HomeScreen,
    BreedImageScreen;

    companion object {
        fun fromRoute(route: String): AppScreens =
            when(route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                BreedImageScreen.name -> BreedImageScreen
                null -> HomeScreen
                else -> { throw IllegalArgumentException("Route $route is  not recognized")}
            }
    }
}