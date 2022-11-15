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

    /**
     * Funciones orden superior
     */
    private fun calculadora(n1:Int, n2:Int, fn:(Int,Int)->Int):Int{
        return fn(n1,n2)
    }

    private fun sumar(x:Int, y: Int):Int { return x+y }
    private fun restar(x:Int, y: Int):Int { return x-y }
    private fun multiplicar(x:Int, y: Int):Int = x*y
    private fun dividir(x:Int, y: Int):Int = x/y

    /**
     * Funciones de orden superior en objetos
     */
    private fun inColombia(h:Float):Boolean{
        return h>=1.6f
    }
    private fun inSpain(h:Float):Boolean{
        return h>=1.65f
    }

    private fun Person.checkPolicia(fn: (Float)->Boolean):Boolean{
        return fn(height)
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

        /**
         * Funciones de orden superior
         */
        println("La suma entre 80 y 20 es ${calculadora(80,20,::sumar)}")
        println("La resta entre 50 y 10 es ${calculadora(50,10,::restar)}")
        println("La multiplicacion entre 7 y 7 es ${calculadora(7,7,::multiplicar)}")
        println("La division entre 12 y 3 es ${calculadora(12,3,::dividir)}")

        /**
         * Lambdas
         */
        var funcion = { x:Int, y:Int -> x+y }
        println("La suma entre 80 y 20 con variable es ${calculadora(80,20, funcion)}")
        funcion = { x:Int, y:Int -> x-y }
        println("La resta entre 50 y 10 con variable es ${calculadora(50,10, funcion)}")

        println("La suma entre 80 y 20 con lambda es ${calculadora(80,20, { x:Int, y:Int -> x+y })}")
        println("La resta entre 50 y 10 con lambda es ${calculadora(50,10, { x:Int, y:Int -> x-y })}")
        println("La Potencia de 2 elevado a la 5 con lambda es ${calculadora(2,5) { x, y ->
            var valor = 1
            for (i in 1..y) valor *= x
            valor
        }
        }")

        var array4 = IntArray(10) {5}
        println("Array4: ")
        array4.show()

        var array5 = IntArray(10) {it}
        println("Array5: ")
        array5.show()

        var array6 = IntArray(10) {it*2}
        println("Array6: ")
        array6.show()

        var array7 = IntArray(10) {i -> i*3}
        println("Array7: ")
        array7.show()

        var num:Int = 0
        var juan:Person = Person("Juan Jose","1053847013",1.62f)
        var anonimo:Person = Person()
        println(juan.alive)
        println(juan.name)
        println(juan.passport)
        //if(juan.checkPolicia(::inColombia)) println("${juan.name} puede ser policia en Colombia")
        //if(juan.checkPolicia(::inSpain)) println("${juan.name} puede ser policia en España")

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