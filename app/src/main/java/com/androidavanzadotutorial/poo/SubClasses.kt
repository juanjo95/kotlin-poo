package com.androidavanzadotutorial.poo

class SubClasses {
    private var name:String = "Padre"
    fun presentar():String { return this.name}

    class Anidada{
        private var nameAnidada:String = "Anidada"
        fun presentar():String { return this.nameAnidada}

    }

    inner class Interna{
        private val nameInterna:String = "Interna"
        fun presentar():String {
            return "Hola soy ${this.nameInterna}, hija de ${name}"
        }
    }

}