package com.example.agrohold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun onClickAutor(view: View) {
        var i = Intent(this,AutorActivity::class.java)
        startActivity(i)
    }
    fun onClickAboutApp(view: View) {
        var i = Intent(this,AboutApp::class.java)
        startActivity(i)
    }
    fun onClickCopyrights(view: View) {
        var i = Intent(this,CopyrightsActivity::class.java)
        startActivity(i)
    }
}