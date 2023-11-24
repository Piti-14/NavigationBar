package com.example.coffeshops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeshops.ui.theme.CoffeShop
import com.example.navigationbar.R
import com.example.navigationbar.ui.theme.CoffeShopsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeShopsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val comments = initComments()
                    val coffeshops = getAllCafes(comments)

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "ShopList"){
                        composable("ShopList") { AppInit(navController, coffeshops) }
                        composable("CommentsSection") { CommentPage(comments) }

                    }
                }
            }
        }
    }
}

fun getAllCafes(comments: List<String>): List<CoffeShop> {
    return listOf(
        CoffeShop(
            "Antico Caffè Greco",
            "St. Italy, Rome",
            R.drawable.images,
            comments
        ),
        CoffeShop(
            "Coffe Room",
            "St. Germany, Berlin",
            R.drawable.images1,
            comments
        ),
        CoffeShop(
            "Coffe Ibiza",
            "St. Colon, Madrid",
            R.drawable.images2,
            comments
        ),
        CoffeShop(
            "Pudding Coffe Shop",
            "St. Diagonal, Barcelona",
            R.drawable.images3,
            comments
        ),
        CoffeShop(
            "L' Expresso",
            "St. Picadilly Circus, London",
            R.drawable.images4,
            comments
        ),
        CoffeShop(
            "Coffe Corner",
            "St. Àngel Guimerà, Valencia",
            R.drawable.images5,
            comments
        ),
        CoffeShop(
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam",
            R.drawable.images6,
            comments
        )
    )
}

fun initComments(): List<String> {
    return listOf<String>(
        "Excelente café y ambiente histórico",
        "Una joya de lugar",
        "Me encanta este sitio",
        "El mejor café",
        "Gran experiencia en cada visita",
        "Un lugar con mucha historia",
        "El espresso es magnífico",
        "Una experiencia única",
        "Altamente recomendado",
        "A veces el personal es un poco antipático",
        "Horarios muy malos",
        "No volveremos",
        "El dueño ha cambiado recientemente",
        "Demasiado caro para lo que ofrecen",
        "Depende de la hora, puede que no haya sitio",
        "La zona en la que se encuentra es algo ruidosa",
        "Me encantaba de pequeña pero ha cambiado mucho",
        "Genial para probar variedades nuevas o exóticas"
    )
}