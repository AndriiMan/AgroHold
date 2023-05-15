package com.example.agrohold

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)

        Snackbar.make(findViewById(R.id.splash_activity), "Harvesting Welcomes you ✨", Toast.LENGTH_SHORT)
            .setBackgroundTint(resources.getColor(R.color.black))
            .setTextColor(resources.getColor(R.color.white))
            .show()
    }
}