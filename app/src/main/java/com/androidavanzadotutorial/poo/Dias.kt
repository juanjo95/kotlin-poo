package com.androidavanzadotutorial.poo

enum class Dias(val laboral:Boolean, val horas: Int) {
    LUNES(true,9),MARTES(true,8),MIERCOLES(true,7),JUEVES(true,6),VIERNES(true,5),SABADO(false,0),DOMINGO(false,0);

    fun saludar():String {
        when(this){
            LUNES -> return "Empezando con alegria!!!"
            MARTES -> return "Ya queda menos"
            MIERCOLES -> return "Son los dias mas productivos"
            JUEVES -> return "Esta noche es juernes"
            VIERNES -> return "Hoy es viernes y tu cuenpo lo sabe"
            else -> return "A quemar el finde"
        }
    }
}