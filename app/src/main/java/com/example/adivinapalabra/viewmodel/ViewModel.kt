package com.example.adivinapalabra.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.adivinapalabra.model.Diccionario
import kotlin.random.Random

class ViewModel:ViewModel() {

    val random = Random


    fun setPalabraDir(){
        var numeroAleatorioDiccionario = random.nextInt(1,21)
        var palabraDir = checkPalabra(numeroAleatorioDiccionario)
        Log.d("Comprobando", palabraDir)
    }

    private fun checkPalabra(id: Int): String {
        val palabra = Diccionario.entries.find { it.id == id }
        if (palabra != null) {
            return palabra.nombre
        }
        return ""
    }

}