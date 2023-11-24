package com.example.coffeshops.ui.theme

import androidx.annotation.DrawableRes

data class CoffeShop(
    var name: String,
    var addr: String,
    @DrawableRes var image: Int,
    var comments: List<String>
)
