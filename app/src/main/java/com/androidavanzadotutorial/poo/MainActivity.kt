package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    object ejemplo {
        var apodo = "Eje"
        fun saludo(){
            println("Hola, me llaman $apodo")
        }
    }

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
        anonimo.name = "Pablo"
        println(anonimo.alive)
        println(anonimo.name)
        println(anonimo.passport)

        juan.die()
        println(juan.alive)

        var pele:Athlete = Athlete("Pele", "123456789","Futbol")
        println(pele.alive)
        println(pele.name)
        println(pele.passport)
        println(pele.sport)

        pele.die()
        println(pele.alive)

        var bicho:Pokemon = Pokemon()
        println(bicho.getName())
        println(bicho.getAttackPower())
        bicho.setLife(65f)
        println(bicho.getLife())

        var sc = SubClasses()
        println(sc.presentar())

        var ani = SubClasses.Anidada()
        println(ani.presentar())

        var int = SubClasses().Interna()
        println(int.presentar())

        println(ejemplo.saludo())
        ejemplo.apodo = "SuperEjemplo"
        println(ejemplo.saludo())
    }
}