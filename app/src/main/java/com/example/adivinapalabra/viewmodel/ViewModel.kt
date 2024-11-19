package com.example.adivinapalabra.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.adivinapalabra.model.Datos
import com.example.adivinapalabra.model.Diccionario
import kotlin.random.Random

class ViewModel:ViewModel() {

    val random = Random


    fun setPalabraDir(){
        var numeroAleatorioDiccionario = random.nextInt(1,21)
        var palabraDir = checkPalabra(numeroAleatorioDiccionario)
        var sinonimoDir = checkSinonimo(palabraDir)
        Log.d("Comprobando", palabraDir)
        Log.d("Comprobando", sinonimoDir)
    }

    private fun checkPalabra(id: Int): String {
        val palabra = Diccionario.entries.find { it.id == id }
        if (palabra != null) {
            Datos.palabra = palabra.nombre
            return palabra.nombre
        }
        return ""
    }

     fun checkSinonimo(palabra:String):String{
        val sinoninoDir = Diccionario.entries.find { it.nombre == palabra }
        if(sinoninoDir != null){
            Datos.sinonimo = sinoninoDir.sinonimo
            return sinoninoDir.sinonimo
        }
        return ""
    }

    fun getPalabra():String{
        return Datos.palabra
    }

    fun getSinonimo():String{
        return Datos.sinonimo
    }

    fun getRonda():Int{
        return Datos.ronda
    }

    fun getAciertos():Int{
        return Datos.aciertos
    }

    fun getFallos():Int{
        return Datos.fallos
    }




}