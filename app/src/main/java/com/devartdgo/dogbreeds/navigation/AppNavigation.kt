package com.devartdgo.dogbreeds.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devartdgo.dogbreeds.screens.BreedImageScreen
import com.devartdgo.dogbreeds.screens.HomeScreen

@Composable
fun AppNavigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name) {
        composable(AppScreens.HomeScreen.name)
        {
            HomeScreen(navController = navController)
        }
        composable(
            AppScreens.BreedImageScreen.name + "/{breed}",
            arguments = listOf(navArgument("breed") {type = NavType.StringType})
        )
        {backStackEntry ->
            BreedImageScreen(navController = navController, backStackEntry.arguments?.getString("breed"))
        }
    }
}