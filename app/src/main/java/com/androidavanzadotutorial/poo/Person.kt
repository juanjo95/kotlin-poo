package com.androidavanzadotutorial.poo

open class Person(var name:String = "Anonimo", var passport:String? = null) {

    var alive:Boolean = true

    fun Person(){
        name = "Pedro"
        passport = "1234567"
    }

    fun die(){
        alive = false
    }

}