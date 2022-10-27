package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num:Int = 0
        var juan:Person = Person()

        println(juan.alive)
        juan.die()
        println(juan.alive)
    }
}