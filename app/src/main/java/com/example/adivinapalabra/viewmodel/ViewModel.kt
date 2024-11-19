package com.example.adivinapalabra.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adivinapalabra.model.Datos
import com.example.adivinapalabra.model.Diccionario
import kotlin.random.Random

class ViewModel:ViewModel() {

    val random = Random

    private val _sinonimoLiveData = MutableLiveData<String>()
    val sinonimoLiveData : LiveData<String> get() = _sinonimoLiveData

    private var _rondasLiveData = MutableLiveData<Int>()
    val rondasLiveData: LiveData<Int> get() = _rondasLiveData

    private var _aciertosLiveData = MutableLiveData<Int>()
    val aciertosLiveData: LiveData<Int> get() = _aciertosLiveData

    private var _fallosLiveData = MutableLiveData<Int>()
    val fallosLiveData: LiveData<Int> get() = _fallosLiveData

    init {
        _sinonimoLiveData.value = Datos.sinonimo
        _rondasLiveData.value = Datos.ronda
        _aciertosLiveData.value = Datos.aciertos
        _fallosLiveData.value = Datos.fallos
    }



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
            setSinonimo(sinoninoDir.sinonimo)
            return sinoninoDir.sinonimo
        }
        return ""
    }

    fun setSinonimo(sinonimoDir:String){
        Datos.sinonimo = sinonimoDir
        _sinonimoLiveData.value = Datos.sinonimo
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