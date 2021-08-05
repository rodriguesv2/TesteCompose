package br.com.rubensrodrigues.testecompose.flow

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Graph() {
    val navController = rememberNavController()
    navController.enableOnBackPressed(true)
    
    NavHost(
        navController = navController,
        startDestination = "tela01"
    ) {
        composable("tela01") {
            Tela01 {
                navController.navigate("tela02")
            }
        }

        composable("tela02") {
            Tela02()
        }
    }
}