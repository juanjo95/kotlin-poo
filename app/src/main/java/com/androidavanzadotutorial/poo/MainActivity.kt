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

    private fun String.noSpaces():String{
        return this.replace(" ","")
    }

    private fun IntArray.show(){
        print("[")
        for (i in this) print("$i ")
        println("]")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            Funciones de extension
         */
        var usuario:String = "    soy  yo  "
        println("${usuario} (${usuario.length}) ---- ${usuario.noSpaces()} (${usuario.noSpaces().length})")

        var array1:Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9)
        var array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30
        println("Array2: ")
        array2.show()
        var array3:IntArray = intArrayOf(1,2,3,4)
        println("Array3: ")
        array3.show()

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

        var sol:Star = Star("Sol",696340f, "Via lactea")
        println(sol)
        println(sol.alive)
        sol.alive = false
        println(sol.alive)

        var nueva:Star = Star()
        println(nueva)

        var hoy:Dias = Dias.MARTES
        var semana = Dias.values()
        for (i in semana) println(i)

        println(Dias.valueOf("MIERCOLES"))
        println(hoy.name)
        println(hoy.ordinal)

        println(hoy.saludar())
        println(hoy.laboral)
        println(hoy.horas)
        hoy =  Dias.DOMINGO


    }
}