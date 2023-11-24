package com.example.navigationbar

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationbar.ui.theme.NavigationBarTheme

@Composable
fun BottomNavigationBar(){

    NavigationBar {

    }
}
@Composable
fun Navigation(){
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(Screen.MainScreen.route){ NavigationBarTheme{} }

    }

}