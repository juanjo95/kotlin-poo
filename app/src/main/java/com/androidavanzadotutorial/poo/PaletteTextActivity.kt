package com.androidavanzadotutorial.poo

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class PaletteTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_text)

        var tvEjemplo:TextView = findViewById(R.id.tvEjemplo)
        tvEjemplo.apply {
            this.text = "Texto cambiado desde codigo"
            this.setTextColor(Color.RED)
            this.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
        }

        tvEjemplo.setOnClickListener {
            Toast.makeText(this,"Texto",Toast.LENGTH_SHORT).show()
            tvEjemplo.setTextColor(Color.GREEN)
        }

        var etEjemplo: EditText = findViewById(R.id.etEjemplo)
        etEjemplo.addTextChangedListener {
            if(etEjemplo.text.length == 0) etEjemplo.setError("Campo vacio")
        }

        etEjemplo.setSelection(3)
        var inicio = etEjemplo.selectionStart
        var fin = etEjemplo.selectionEnd
        etEjemplo.selectAll()

        /*
            tipos de inputType

            text 	            Recibe texto plano simple
            textPersonName 	    Texto correspondiente al nombre de una persona
            textPassword 	    Protege los caracteres que se van escribiendo con puntos
            numberPassword 	    Contraseña de solo números enmascarada con puntos
            textEmailAddress 	Texto que será usado en un campo para emails
            phone 	            Texto asociado a un número de teléfono
            textPostalAddress 	Para ingresar textos asociados a una dirección postal
            textMultiLine 	    Permite múltiples líneas en el campo de texto
            time 	            Texto para determinar la hora
            date 	            Texto para determinar la fecha
            number 	            Texto con caracteres numéricos
            numberSigned 	    Permite números con signo
            numberDecimal 	    Para ingresar números decimales
         */

        var autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        var countries: Array<String> = resources.getStringArray(R.array.countries_array)
        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries)

        autoCompleteTextView.setAdapter(adapter)

        var multiAutoCompleteTextView: MultiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


    }
}