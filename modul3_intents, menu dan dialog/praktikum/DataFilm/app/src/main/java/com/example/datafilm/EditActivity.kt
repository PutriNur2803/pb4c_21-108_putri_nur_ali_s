package com.example.datafilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.datafilm.data.Film
import com.example.datafilm.data.FilmDB
import com.example.datafilm.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private lateinit var database: FilmDB
    private var intentId: Int = 0
    private var intentType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FilmDB.getInstance(applicationContext)


        var intent = intent.extras
        if (intent!=null){
            intentType = intent.getInt("intent_type", 0)
            intentId = intent.getInt("id", 0)

            if (intentType == 0){
                // Tampil detail
                binding.btnSave.visibility = View.GONE
                getData(intentId)
            } else {
                binding.btnSave.text = "Edit"
                getData(intentId)
            }
        }


        binding.btnSave.setOnClickListener{
            if (binding.editJudul.text.isNotEmpty() && binding.editTahun.text.isNotEmpty() && binding.editSinopsis.text.isNotEmpty()){
                if (intent!=null){
                    // Edit Data
                    database.filmDao().updateData(
                        Film(
                            intentId,
                            binding.editJudul.text.toString(),
                            binding.editTahun.text.toString(),
                            binding.editSinopsis.text.toString())

                    )
                    finish()
                } else {
                    // Add Data
                    database.filmDao().addData(
                        Film(0,
                            binding.editJudul.text.toString(),
                            binding.editTahun.text.toString(),
                            binding.editSinopsis.text.toString())

                    )
                    finish()
                }

            }else{
                Toast.makeText(applicationContext, "Silahkan isi data dengan valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getData(id: Int){
        var films = database.filmDao().getData(id)[0]
        binding.editJudul.setText(films.judul)
        binding.editTahun.setText(films.tahun)
        binding.editSinopsis.setText(films.sinopsis)

    }
}