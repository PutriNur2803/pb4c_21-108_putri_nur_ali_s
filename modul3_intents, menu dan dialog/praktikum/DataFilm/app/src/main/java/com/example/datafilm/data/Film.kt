package com.example.datafilm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Film(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var judul: String,
    var tahun: String,
    var sinopsis: String
)
