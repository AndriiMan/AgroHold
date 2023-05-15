package com.example.agrohold

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SeasonSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season_selection)

        // Action bar title changed to Getting started
        supportActionBar?.title = "Getting started!"

        generateRandomFact()

        val seasonRadioGrp = findViewById<RadioGroup>(R.id.seasonRadioGrp)
        seasonRadioGrp.setOnCheckedChangeListener { radioGroup, j ->
            val radiobuttonChecked = findViewById<RadioButton>(j)
            if(radiobuttonChecked!=null){

                // Converting Name of the ID selected
                val selectedSeasonData = radiobuttonChecked.text.toString()

                // Preparing to send the data
                val soilSelectionIntent = Intent (applicationContext, SoilSelection::class.java)

                // Sending the data with the key
                soilSelectionIntent.putExtra("seasonData_key",selectedSeasonData)
                startActivity(soilSelectionIntent) // data sent with going to next screen
                radioGroup.clearCheck()
            }
        }
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