package com.androidavanzadotutorial.poo

open class Person(var name:String = "Anonimo", var passport:String? = null) : Thanks(), SayBay, SayBye2 {

    var alive:Boolean = true
    override var dato: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    fun Person(){
        name = "Pedro"
        passport = "1234567"
    }

    fun die(){
        alive = false
        this.thanksCure()
    }

}