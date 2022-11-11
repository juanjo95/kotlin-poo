package com.androidavanzadotutorial.poo

open abstract class Deportista(var nombre:String, var estatura:Float, var peso:Float, var edad:Int) {

    fun descansar(){
        println("Mostrando mensaje de descansar")
    }

    abstract fun competir()
}

class Runner(nombre:String,estatura:Float,peso:Float,edad:Int,var estilo:String, var velocidad:Int) : Deportista(nombre,estatura,peso,edad){

    fun correr(){
        println("El runner $nombre, del estilo $estilo se ha puesto a runner a una velocidad de $velocidad km/h")
    }

    override fun competir() {
        println("voy a correr!!!")
    }


}

class Ciclista(nombre:String,estatura:Float,peso:Float,edad:Int,var tipo_bici:String, var velocidad: Int) : Deportista(nombre,estatura,peso,edad){

    fun pedalear(){
        println("El ciclista $nombre, del tipo biciclta $tipo_bici se ha puesto a pedalear a una velocidad de $velocidad km/h")
    }

    override fun competir() {
        println("voy a pedalear!!!")
    }

}

class Nadador(nombre:String,estatura:Float,peso:Float,edad:Int, var estilo: String, var velocidad: Int) : Deportista(nombre,estatura,peso,edad){

    fun nadar(){
        println("El nadador $nombre, de estilo $estilo se ha puesto a nadar a una velocidad de $velocidad km/h")
    }

    override fun competir() {
        println("voy a nadar!!!")
    }
}
