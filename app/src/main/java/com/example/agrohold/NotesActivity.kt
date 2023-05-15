package com.example.agrohold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agrohold.R.layout.activity_notes
import com.example.agrohold.db.MyAdapter
import com.example.agrohold.db.MyDbManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NotesActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList(), this)
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        init()
        initSearchView()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        fillAdapter("")
    }

    fun onClickNew(view: View) {
        var i = Intent(this,EditActivity::class.java)
        startActivity(i)
    }

    fun init(){
        val rcView = findViewById<RecyclerView>(R.id.rcView)

        rcView.layoutManager = LinearLayoutManager(this)
        val swapHelper = getSwapMg()
        swapHelper.attachToRecyclerView(rcView)
        rcView.adapter = myAdapter
    }

    private fun initSearchView(){
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                fillAdapter(text!!)
                return true
            }
        })
    }

    private fun fillAdapter(text: String){

        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch{

            val list = myDbManager.readDbData(text)
            myAdapter.updateAdapter(list)
            val tvNoElements = findViewById<TextView>(R.id.tvNoElements)
            if(list.size > 0){
                tvNoElements.visibility = View.GONE
            }
            else{
                tvNoElements.visibility = View.VISIBLE
            }
        }
    }

    private fun getSwapMg(): ItemTouchHelper{
        return ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                myAdapter.removeItem(viewHolder.adapterPosition, myDbManager)
            }
        })
    }

    fun onClickMenu(view: View) {
        var i = Intent(this,MenuActivity::class.java)
        startActivity(i)
    }
}