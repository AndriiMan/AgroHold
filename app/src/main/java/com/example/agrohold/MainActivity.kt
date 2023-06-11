package com.example.agrohold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide action bar
        supportActionBar?.hide()

        val fabNextToSeason = findViewById<FloatingActionButton>(R.id.fab_next_to_season)
        fabNextToSeason.setOnClickListener {
            startActivity(Intent(this,SeasonSelection::class.java))
        }

        val fabNotes = findViewById<FloatingActionButton>(R.id.fab_next_to_season2)
        fabNotes.setOnClickListener {
            startActivity(Intent(this,NotesActivity::class.java))
        }
    }
}