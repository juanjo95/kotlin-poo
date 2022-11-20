package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    }
}