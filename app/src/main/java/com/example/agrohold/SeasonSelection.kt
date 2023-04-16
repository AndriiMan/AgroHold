package com.example.agrohold

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthyharvest.R

class SeasonSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season_selection)

        // Action bar title changed to Getting started
        supportActionBar?.title = "Getting started!"

        generateRandomFact()
    }
    private fun generateRandomFact(){
        val funFactsArray = arrayOf(
            "More than 60000 varieties of 🍎 are grown around the world.",
            "Agronomy has existed and been important for humans since the invention of farming",
            "Technically 🍅 is a fruit.",
            "A pomegranate can hold up to 10000 seeds."
        )

        // Generating Random facts on the season screen
        val randomFactsText = findViewById<TextView>(R.id.random_facts)
        randomFactsText.text = funFactsArray.random()
        Log.d("Random Fact", funFactsArray.random())
    }
}