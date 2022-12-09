package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class SearchviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchview)

        /**
         * SearchView desde xml
         */
        val users = arrayOf("Alberto","Alvaro","Ana","Amparo","Bartolo","Bernando","Carla","Carlos","Carolina")
        val adapterUsers: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)

        val svUsers: SearchView = findViewById(R.id.svUsers)
        val lvUsers: ListView = findViewById(R.id.lvUsers)
        lvUsers.adapter = adapterUsers
        svUsers.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                svUsers.clearFocus()
                if(users.contains(query)) adapterUsers.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapterUsers.filter.filter(query)
                return false
            }

        })
    }
}