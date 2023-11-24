package com.example.coffeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffeshops.ui.theme.CoffeShop
import com.example.coffeshops.ui.theme.coffe
import java.lang.Math.ceil
import java.lang.Math.floor

@Composable
fun AppInit(navController: NavHostController, coffeshops: List<CoffeShop>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item(coffeshops) { CreateCoffeCards(coffeshops, navController) }
    }
}

@Composable
fun CreateCoffeCards(coffeshops: List<CoffeShop>, navController: NavHostController) {
    for (shop in coffeshops) {
        ItemShop(shop, navController )
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun ItemShop(coffeshop: CoffeShop, navController: NavHostController) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .clickable { navController.navigate("CommentsSection") }
    ) {
        Image(
            painter = painterResource(id = coffeshop.image),
            contentDescription = "shop",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 1.dp, height = 200.dp)
        )

        Spacer(Modifier.height(5.dp))

        Text(text = coffeshop.name, style = coffe)

        RatingBar()

        Text(text = coffeshop.addr)
        Divider()
        TextButton(onClick = { /*TODO*/ }) {Text(text = "RESERVE")}

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingBar() {
    val range = 0f..5f
    val steps = 5

    var selection by rememberSaveable {mutableStateOf(0f)}

    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = {selection = it},
        modifier = Modifier.padding(15.dp,0.dp, 15.dp,0.dp),
        colors = SliderDefaults.colors(Color.Yellow)
    )
}

/* fun ShowSlider(): Float {
    val range = 0f..10f
    val steps = 9

    var selection by remember {mutableStateOf(0f)}

    Slider(
        value = selection,
        valueRange = range,
        steps = steps,
        onValueChange = {selection = it},
        modifier = Modifier.padding(15.dp,0.dp, 15.dp,0.dp),
        //colors = SliderDefaults.colors(Color.Yellow)
    )

    return selection
} */


/*@Preview
@Composable
fun PreviewMain() {
    val navController = rememberNavController()
    AppInit(navController)
}*/
