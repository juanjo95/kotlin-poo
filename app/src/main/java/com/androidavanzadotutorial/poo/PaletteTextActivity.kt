package com.androidavanzadotutorial.poo

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
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

        var autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        var countries: Array<String> = resources.getStringArray(R.array.countries_array)
        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries)

        autoCompleteTextView.setAdapter(adapter)


    }
}