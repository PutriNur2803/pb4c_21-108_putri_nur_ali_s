package com.example.datafilm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Film::class],
    version = 1
)

abstract class FilmDB : RoomDatabase(){
    abstract fun filmDao(): FilmDao

    companion object{
        private var instance: FilmDB? = null

        fun getInstance(context: Context): FilmDB{
            if (instance == null){
                instance = Room.databaseBuilder(context, FilmDB::class.java, "film")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}