package com.example.agrohold

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.agrohold.db.MyDbManager
import com.example.agrohold.db.MyIntentConstants
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class EditActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    val myDbManager = MyDbManager(this)

    var id = 0
    var isEditState = false
    val imageRequestCode = 10
    var tempImageUri = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fbGetLoc).setOnClickListener{
            fetchLocation()
        }



        getMyIntents()
    }

    private fun fetchLocation() {
        val task = fusedLocationProviderClient.lastLocation

        if(ActivityCompat.checkSelfPermission (this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }
        task.addOnSuccessListener {
            if(it != null)
            {
                Toast.makeText(applicationContext, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == imageRequestCode){
            val imMainImage = findViewById<ImageView>(R.id.imMainImage)

            imMainImage.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
            contentResolver.takePersistableUriPermission(data?.data!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    fun onClickAddImage(view: View) {
        val mainImageLayout = findViewById<View>(R.id.mainImageLayout)
        val fbAddImage = findViewById<View>(R.id.fbAddImage)

        mainImageLayout.visibility = View.VISIBLE
        fbAddImage.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {
        val mainImageLayout = findViewById<View>(R.id.mainImageLayout)
        val fbAddImage = findViewById<View>(R.id.fbAddImage)

        mainImageLayout.visibility = View.GONE
        fbAddImage.visibility = View.VISIBLE
        tempImageUri = "empty"
    }

    fun onClickChooseImage(view: View) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startActivityForResult(intent, imageRequestCode)
    }

    fun onClickSave(view: View) {

        val toast = Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT)
        toast.show()

        val edTitle = findViewById<TextView>(R.id.edTitle)
        val edDesc = findViewById<TextView>(R.id.edDesc)

        val myTitle = edTitle.text.toString()
        val myDesc = edDesc.text.toString()
        val myTime = Calendar.getInstance().time


        CoroutineScope(Dispatchers.Main).launch {
            if(myTitle != "" && myDesc != ""){
                if(isEditState){
                    myDbManager.updateItem(myTitle, myDesc, tempImageUri, id, getCurrentTime())
                }
                else {
                    myDbManager.insertToDb(myTitle, myDesc, tempImageUri, getCurrentTime())
                }
                finish()
            }
        }

    }

    fun onEditEnable(view: View){
        val edTitle = findViewById<TextView>(R.id.edTitle)
        val edDesc = findViewById<TextView>(R.id.edDesc)
        val fbEdit = findViewById<View>(R.id.fbEdit)
        val imButtonEditImage = findViewById<View>(R.id.imButtonEditeImage)
        val imButtonDeleteImage = findViewById<View>(R.id.imButtonDeleteImage)
        val fbAddImage = findViewById<View>(R.id.fbAddImage)

        fbEdit.visibility = View.GONE
        edTitle.isEnabled = true
        edDesc.isEnabled = true
        fbAddImage.visibility = View.VISIBLE
        if(tempImageUri == "empty") return
        imButtonEditImage.visibility = View.VISIBLE
        imButtonDeleteImage.visibility = View.VISIBLE
    }

    fun getMyIntents(){
        val fbEdit = findViewById<View>(R.id.fbEdit)

        fbEdit.visibility = View.GONE
        val i = intent

        if(i != null){
            if(i.getStringExtra(MyIntentConstants.I_TITLE_KEY) != null){
                val edTitle = findViewById<TextView>(R.id.edTitle)
                val edDesc = findViewById<TextView>(R.id.edDesc)
                val fbAddImage = findViewById<View>(R.id.fbAddImage)


                fbAddImage.visibility = View.GONE
                edTitle.setText(i.getStringExtra(MyIntentConstants.I_TITLE_KEY))
                isEditState = true
                edTitle.isEnabled = false
                edDesc.isEnabled = false
                fbEdit.visibility = View.VISIBLE
                edDesc.setText(i.getStringExtra(MyIntentConstants.I_DESC_KEY))
                id = i.getIntExtra(MyIntentConstants.I_ID_KEY, 0)

                if(i.getStringExtra(MyIntentConstants.I_URI_KEY) != "empty"){
                    val mainImageLayout = findViewById<View>(R.id.mainImageLayout)
                    val imMainImage = findViewById<ImageView>(R.id.imMainImage)
                    val imButtonDeleteImage = findViewById<View>(R.id.imButtonDeleteImage)
                    val imButtonEditeImage = findViewById<View>(R.id.imButtonEditeImage)

                    mainImageLayout.visibility = View.VISIBLE
                    tempImageUri = i.getStringExtra(MyIntentConstants.I_URI_KEY)!!
                    imMainImage.setImageURI(Uri.parse(tempImageUri))
                    imButtonDeleteImage.visibility = View.GONE
                    imButtonEditeImage.visibility = View.GONE
                }
            }
        }
    }

    private fun getCurrentTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yy kk:mm", Locale.getDefault())
        return formatter.format(time)
    }
}