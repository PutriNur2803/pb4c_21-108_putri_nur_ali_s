package com.example.datafilm

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datafilm.data.Film
import com.example.datafilm.data.FilmDB
import com.example.datafilm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var filmAdapter: FilmAdapter
    private var list = mutableListOf<Film>()
    private lateinit var database: FilmDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FilmDB.getInstance(applicationContext)
        filmAdapter = FilmAdapter(list)
        filmAdapter.setDialog(object: FilmAdapter.Dialog{
            override fun onClick(position: Int) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle(list[position].judul)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{ dialog, which ->
                    if (which == 0){
                        val intent = Intent(this@MainActivity,EditActivity::class.java)
                        intent.putExtra("id", list[position].id)
                        intent.putExtra("intent_type", 0)
                        startActivity(intent)
                    }
                    else if (which == 1){
                        val intent = Intent(this@MainActivity,EditActivity::class.java)
                        intent.putExtra("id", list[position].id)
                        intent.putExtra("intent_type", 1)
                        startActivity(intent)
                    } else if (which == 2){
                        database.filmDao().deleteData(list[position])
                        getData()
                    } else {
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()
            }

        })

        binding.recyclerView.adapter = filmAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        binding.fab.setOnClickListener{
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.filmDao().getAllData())
        filmAdapter.notifyDataSetChanged()
    }
}