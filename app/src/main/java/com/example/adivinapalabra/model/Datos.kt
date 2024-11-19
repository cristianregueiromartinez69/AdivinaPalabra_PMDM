package com.example.adivinapalabra.model

object Datos {
    var palabra = ""
    var sinonimo = ""
    var ronda = 0
    var aciertos = 0
    var fallos = 0
}

enum class Diccionario(val id:Int, val nombre:String){
    PALABRA1(id = 1, "amor"),
    PALABRA2(id = 2, "felicidad"),
    PALABRA3(id = 3, "tristeza"),
    PALABRA4(id = 4, "rapido"),
    PALABRA5(id = 5, "lento"),
    PALABRA6(id = 6, "fuerte"),
    PALABRA7(id = 7, "debil"),
    PALABRA8(id = 8, "hermoso"),
    PALABRA9(id = 9, "grande"),
    PALABRA10(id = 10, "pequeño"),
    PALABRA11(id = 11, "inteligente"),
    PALABRA12(id = 12, "torpe"),
    PALABRA13(id = 13, "frio"),
    PALABRA14(id = 14, "caliente"),
    PALABRA15(id = 15, "facil"),
    PALABRA16(id = 16, "dificil"),
    PALABRA17(id = 17, "contento"),
    PALABRA18(id = 18, "enojado"),
    PALABRA19(id = 19, "oscuro"),
    PALABRA20(id = 20, "claro")

}