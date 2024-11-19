package com.example.adivinapalabra.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adivinapalabra.model.Datos
import com.example.adivinapalabra.model.Diccionario
import com.example.adivinapalabra.model.Estados
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

    val estadoLiveData : MutableLiveData<Estados> = MutableLiveData(Estados.INICIO)

    init {
        _sinonimoLiveData.value = Datos.sinonimo
        _rondasLiveData.value = Datos.ronda
        _aciertosLiveData.value = Datos.aciertos
        _fallosLiveData.value = Datos.fallos
    }



    fun setPalabraDir(){
        estadoLiveData.value = Estados.GENERANDO
        var numeroAleatorioDiccionario = random.nextInt(1,21)
        var palabraDir = checkPalabra(numeroAleatorioDiccionario)
        var sinonimoDir = checkSinonimo(palabraDir)
        Log.d("Comprobando", palabraDir)
        Log.d("Comprobando", sinonimoDir)
        estadoLiveData.value = Estados.ADIVINANDO
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
    
    fun winOrLose(palabraJugador:String, palabraMaquina:String){
        if (palabraJugador.equals(palabraMaquina)){

        }
    }

    fun setSinonimo(sinonimoDir:String){
        Datos.sinonimo = sinonimoDir
        _sinonimoLiveData.value = Datos.sinonimo
    }

    fun setPalabra(texto:String){
        Datos.palabra = texto
    }

    fun setRondas(){
        Datos.ronda += 1
        _rondasLiveData.value = Datos.ronda
    }

    fun setAciertos(){
        Datos.aciertos += 1
        _aciertosLiveData.value = Datos.aciertos
    }

    fun setFallos(){
        Datos.fallos += 1
        _fallosLiveData.value  = Datos.fallos
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

    fun restartRondas(){
        Datos.ronda = 0
        _rondasLiveData.value = Datos.ronda
    }

    fun restartAciertos(){
        Datos.aciertos = 0
        _aciertosLiveData.value = Datos.aciertos
    }

    fun restartFallos(){
        Datos.fallos = 0
        _fallosLiveData.value  = Datos.fallos
    }




}