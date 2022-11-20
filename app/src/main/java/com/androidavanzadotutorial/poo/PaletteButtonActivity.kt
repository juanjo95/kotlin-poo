package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class PaletteButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_button)

        var cgCondiciones: ChipGroup = findViewById(R.id.cgCondiciones)
        var chip:Chip
        for (i in 0..cgCondiciones.childCount-1){
            chip = cgCondiciones.getChildAt(i) as Chip
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER

            chip.setOnCloseIconClickListener {
                cgCondiciones.removeView(it)
            }

            chip.setOnClickListener {
                var aux:Chip = it as Chip
                Toast.makeText(this,"${aux.text} pulsado",Toast.LENGTH_SHORT).show()
            }
        }

        val chipNew = Chip(this)
        chipNew.text = "Nueva"
        chipNew.chipIcon = ContextCompat.getDrawable(this,R.drawable.ic_email)
        chipNew.isChipIconVisible = false
        chipNew.isCloseIconVisible = true
        chipNew.isClickable = true
        chipNew.isCheckable = false

        cgCondiciones.addView(chipNew)
        chipNew.setOnCloseIconClickListener {
            cgCondiciones.removeView(it)
        }
        chipNew.setOnClickListener {
            var aux:Chip = it as Chip
            Toast.makeText(this,"${aux.text} pulsado",Toast.LENGTH_SHORT).show()
        }

        var rgVacaciones = findViewById(R.id.rgVacaciones) as RadioGroup
        var rb = rgVacaciones.getChildAt(1) as RadioButton
        rgVacaciones.check(rb.id)

        /**
         * Checkbox
         */
        var cbSeguro:CheckBox = findViewById(R.id.cbSeguro)
        cbSeguro.isEnabled = true
        cbSeguro.isChecked = true

        /**
         * ToggleButton
         */
        var tgNormal: ToggleButton = findViewById(R.id.tgNormal)
        tgNormal.setOnCheckedChangeListener{_,isChecked ->
            if(isChecked) Toast.makeText(this,"Toggle Activado",Toast.LENGTH_SHORT).show()
            else Toast.makeText(this,"Toggle Desactivado",Toast.LENGTH_SHORT).show()
        }

        /**
         * Switch
         */
        var swNormal: Switch = findViewById(R.id.swNormal)
        swNormal.setOnCheckedChangeListener{_,isChecked ->
            if(isChecked) Toast.makeText(this,"Switch Activado",Toast.LENGTH_SHORT).show()
            else Toast.makeText(this,"Switch Desactivado",Toast.LENGTH_SHORT).show()
        }

    }

    fun onRadioButtonClicked(v:View){
        if(v is RadioButton){
            var checked = v.isChecked

            when(v.id){
                R.id.rbPlaya -> {
                    if(checked) Toast.makeText(this,"Vamos a la playa",Toast.LENGTH_SHORT).show()
                }
                R.id.rbMontaña -> {
                    if(checked) Toast.makeText(this,"Vamos a la montaña",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun onCheckBoxClicked(v:View){
        if(v is CheckBox){
            var checked = v.isChecked

            when(v.getId()){
                R.id.cbSeguro -> {
                    if(checked) Toast.makeText(this,"Seguro contratado",Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this,"Seguro anulado",Toast.LENGTH_SHORT).show()
                }
                R.id.cbCancelable -> {
                    if(checked) Toast.makeText(this,"La reserva podra ser cancelada",Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this,"La reserva NO podra ser cancelada",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}