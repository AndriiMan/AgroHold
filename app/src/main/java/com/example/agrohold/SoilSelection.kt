package com.example.agrohold

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SoilSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soil_selection)

        // val soilSubmit = findViewById<Button>(R.id.soil_submit_button)

        /* val demoText = findViewById<TextView>(R.id.Demo_Text) */

        supportActionBar?.title = "Step 2 : Soil Type ☘"

        /* soilSubmit.setOnClickListener {
            Toast.makeText(this, "Select one soil type!", Toast.LENGTH_SHORT).show()
        } */

        // Season Data Receiving part
        val receivedSeasonSelectionData = intent.getStringExtra("seasonData_key").toString()

        /* demoText.text = receivedSeasonSelectionData */
        val soilSelectionRadioGrp = findViewById<RadioGroup>(R.id.soil_selection_radio_grp)
        soilSelectionRadioGrp.setOnCheckedChangeListener { radioGroup, i ->
            val soilRadioButtonChecked = findViewById<RadioButton>(i)
            if (soilRadioButtonChecked != null) {
                val selectedSoilData = soilRadioButtonChecked.text.toString()

                val resultPageIntent = Intent(applicationContext, ResultPage::class.java)

                resultPageIntent.putExtra("seasonData_key", receivedSeasonSelectionData)
                resultPageIntent.putExtra("soilData_key", selectedSoilData)
                startActivity(resultPageIntent)

                radioGroup.clearCheck()
            }
        }

    }
}