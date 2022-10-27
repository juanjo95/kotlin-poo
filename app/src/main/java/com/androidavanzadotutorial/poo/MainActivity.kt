package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num:Int = 0
        var juan:Person = Person("Juan Jose","1053847013")
        var anonimo:Person = Person()
        println(juan.alive)
        println(juan.name)
        println(juan.passport)

        anonimo.Person()
        println(anonimo.alive)
        println(anonimo.name)
        println(anonimo.passport)

        juan.die()
        println(juan.alive)
    }
}