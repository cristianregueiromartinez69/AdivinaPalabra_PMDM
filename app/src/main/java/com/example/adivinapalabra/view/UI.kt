package com.example.adivinapalabra.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.adivinapalabra.R

@Composable
fun MyApp(viewModel: ViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val backgroundImage = painterResource(id = R.drawable.fondoadivinapalabra)
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            Row {
                ShowRondas(0)
            }
        }
    }
}

@Composable
fun ShowRondas(rondas:Int){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 30.dp, start = 115.dp)
    ) {

        Text(text = "Rondas: $rondas" ,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

    }

}

@Composable
fun ShowSinonimo(sinonimo:String){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 30.dp, start = 115.dp)
    ) {

        Text(text = "Rondas: $sinonimo" ,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

    }

}

