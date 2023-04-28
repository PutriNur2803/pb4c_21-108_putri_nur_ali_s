package com.example.datafilm.data

import androidx.room.*

@Dao
interface FilmDao {
    @Insert
    fun addData(film: Film)

    @Update
    fun updateData(film: Film)

    @Delete
    fun deleteData(film: Film)

    @Query("SELECT * FROM film")
    fun getAllData(): List<Film>

    @Query("SELECT * FROM film WHERE id=:id_film")
    fun getData(id_film: Int): List<Film>
}