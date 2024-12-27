package com.example.cimri.ui.scrren


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable

fun SayfaGecisleri(selectedScreen: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = selectedScreen) {
        composable("anasayfa") {
            HomeScreen(navController = navController)
        }

    }
}