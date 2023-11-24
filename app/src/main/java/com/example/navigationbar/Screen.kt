package com.example.navigationbar

sealed class Screen (val route: String) {
    object MainScreen: Screen("MenuPrincipal")
    object MyPhotos: Screen("Galeria")
    object CoffeShops: Screen("Cafeterias")
    object Sol: Screen("ElSol")
}