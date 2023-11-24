package com.example.coffeshops

import android.content.res.Resources
import android.content.res.XmlResourceParser
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeshops.ui.theme.CoffeShop
import com.example.coffeshops.ui.theme.appfont
import org.xmlpull.v1.XmlPullParser


@Composable
fun AppInit() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {CreateCoffeCards()}
    }
}

@Composable
fun CreateCoffeCards() {
    val coffeshops = getAllCafes()
    for (shop in coffeshops) {
        ItemShop(shop)
    }
}

@Composable
fun ItemShop(coffeshop: CoffeShop) {
    Card(elevation = CardDefaults.cardElevation(10.dp)) {
        Column {
            Image(painter = painterResource(id = coffeshop.image), contentDescription = "")
            Text(text = coffeshop.name, fontFamily = appfont)
            Divider()
            Text(text = coffeshop.addr)
        }
    }
}

fun getAllCafes(): List<CoffeShop> {
    val comments = listOf<String>("Excelente café y ambiente histórico",
                                  "Una joya de lugar",
                                  "Me encanta este sitio",
                                  "El mejor café",
                                  "Gran experiencia en cada visita",
                                  "Un lugar con mucha historia",
                                  "El espresso es magnífico",
                                  "Una experiencia única",
                                  "Altamente recomendado"
    )

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
