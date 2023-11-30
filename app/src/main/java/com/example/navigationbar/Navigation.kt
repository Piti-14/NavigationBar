package com.example.navigationbar

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationbar.ui.theme.CoffeShopsTheme
import com.example.navigationbar.ui.theme.NavigationBarTheme
import com.example.navigationbar.ui.theme.SolTheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var homeIcon = Icons.Outlined.Home
    var photoIcon = Icons.Outlined.PhotoCamera
    var coffeeIcon = Icons.Outlined.Coffee
    var solIcon = Icons.Outlined.LightMode

    var selectedScreen by rememberSaveable {
        mutableStateOf(Screen.MainScreen.route)
    }

    NavigationBar (

    ){
        //Main Screen
        NavigationBarItem(
            selected = selectedScreen == Screen.MainScreen.route,
            onClick = {
                homeIcon = Icons.Filled.Home
                navController.navigate(Screen.MainScreen.route)
            },
            icon = { Icon(imageVector = homeIcon, contentDescription = "Main Page") }
        )

        //MyPhotos Screen
        NavigationBarItem(
            selected = selectedScreen == Screen.MyPhotos.route,
            onClick = {
                homeIcon = Icons.Filled.PhotoCamera
                navController.navigate(Screen.MyPhotos.route)
            },
            icon = { Icon(imageVector = photoIcon, contentDescription = "My Photos") }
        )

        //Coffee Shops Screen
        NavigationBarItem(
            selected = selectedScreen == Screen.CoffeShops.route,
            onClick = {
                homeIcon = Icons.Filled.Coffee
                navController.navigate(Screen.CoffeShops.route)
            },
            icon = { Icon(imageVector = coffeeIcon, contentDescription = "Coffe Shops") }
        )

        //El Sol Screen
        NavigationBarItem(
            selected = selectedScreen == Screen.Sol.route,
            onClick = {
                solIcon = Icons.Filled.LightMode
                navController.navigate(Screen.Sol.route)
            },
            icon = { Icon(imageVector = solIcon, contentDescription = "El Sol") }
        )

    }
}
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(Screen.MainScreen.route){ NavigationBarTheme{} }
        composable(Screen.MyPhotos.route){  }
        composable(Screen.CoffeShops.route){  }
        composable(Screen.Sol.route){ SolTheme {} }
    }
}