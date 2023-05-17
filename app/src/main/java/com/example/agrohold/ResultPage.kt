package com.example.agrohold

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultPage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        supportActionBar?.title = "Crops we recommend"

        val cropRecommendationTextView = findViewById<TextView>(R.id.crop_recommendations_list)
        /* val demoSoilText = findViewById<TextView>(R.id.demo_soil_text)  // Demo Soil Text */

        val cropsNames = arrayOf(
            "Rice\n", "Maize\n", "Sorghum\n", "Oil seeds\n", "Sesame\n", "Cotton\n",
            "Tea\n", "Rubber\n", "Coffee\n", "Ahar Dal\n", "Pearl millet\n",
            "Paddy\n", "Corn\n", "Pumpkin\n", "Cucumber\n", "Bitter rice\n",
            "Watermelon\n", "Pepper\n", "Tomato\n", "Mango\n", "Sugarcane\n",
            "Wheat\n", "Groundnut\n", "Turmeric\n", "Pea\n", "Oats\n",
            "Potato\n", "Beans\n", "Sweet potato\n", "Okra\n", "Barley\n",
            "Pulses\n"
        )

        // Summer Recommendations
        var summerCrops = cropsNames[5]
        fun sumRecomFunction() {
            var i = 11
            var j = 0; while (i <= 30) {
                summerCrops += cropsNames[i];i += 1;j += 1
            }
        }
        sumRecomFunction()

        // Monsoon/Rainy recommendations
        val monAlluvial =
            cropsNames[0] + cropsNames[1] + cropsNames[2] + cropsNames[3] + cropsNames[4] + cropsNames[5]
        val monBlack = cropsNames[0] + cropsNames[5]
        val monRaY = cropsNames[0] + cropsNames[1] + cropsNames[6]
        val monLat =
            cropsNames[0] + cropsNames[6] + cropsNames[7] + cropsNames[8] + cropsNames[3] + cropsNames[5]
        val monAr = cropsNames[1] + cropsNames[5]
        val monForMount = cropsNames[1] + cropsNames[6] + cropsNames[8]
        val monLoamy = cropsNames[9] + cropsNames[10]

        // Season Data Receiving part
        val receivedSeasonSelectionData = intent.getStringExtra("seasonData_key").toString()

        // Soil Data Receiving part
        val receivedSoilSelectionData = intent.getStringExtra("soilData_key").toString()

        when (receivedSeasonSelectionData) {
            "summer" -> when (receivedSoilSelectionData) {
                "Alluvial Soil" -> cropRecommendationTextView.text = summerCrops
                else -> cropRecommendationTextView.text = summerCrops
            }

            "winter" -> when (receivedSoilSelectionData) {
                "Alluvial Soil" -> cropRecommendationTextView.text =
                    cropsNames[21] + cropsNames[30] + cropsNames[3]
                "Red Soil" -> cropRecommendationTextView.text = cropsNames[21] + cropsNames[31]
                "Laterite Soil", "Arid Soil" -> cropRecommendationTextView.text =
                    cropsNames[21] + cropsNames[31] + cropsNames[3]
                "Forest and Mountain Soil" -> cropRecommendationTextView.text =
                    cropsNames[21] + cropsNames[30]
                "Loamy Soil", "Black Soil" -> cropRecommendationTextView.text = cropsNames[21]
            }

            "autumn" -> when (receivedSoilSelectionData) {
                "Alluvial Soil" -> cropRecommendationTextView.text = monAlluvial
                "Black Soil" -> cropRecommendationTextView.text = monBlack
                "Red Soil" -> cropRecommendationTextView.text = monRaY
                "Laterite Soil" -> cropRecommendationTextView.text = monLat
                "Arid Soil" -> cropRecommendationTextView.text = monAr
                "Forest and Mountain Soil" -> cropRecommendationTextView.text = monForMount
                "Loamy Soil" -> cropRecommendationTextView.text = monLoamy
            }
            "spring" -> when (receivedSoilSelectionData) {
                "Alluvial Soil" -> cropRecommendationTextView.text = monAlluvial
                "Black Soil" -> cropRecommendationTextView.text = monBlack
                "Red Soil" -> cropRecommendationTextView.text = monRaY
                "Laterite Soil" -> cropRecommendationTextView.text = monLat
                "Arid Soil" -> cropRecommendationTextView.text = monAr
                "Forest and Mountain Soil" -> cropRecommendationTextView.text = monForMount
                "Loamy Soil" -> cropRecommendationTextView.text = monLoamy
            }
        }

        /* demoSoilText.text = receivedSoilSelectionData */

        // This redirects to HomePage all over

    }
}