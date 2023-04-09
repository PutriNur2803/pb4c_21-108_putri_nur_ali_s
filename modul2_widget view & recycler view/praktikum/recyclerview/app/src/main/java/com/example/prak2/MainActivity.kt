package com.example.prak2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            data("crash landing on you", R.drawable.img1),
            data("desendants of the sun", R.drawable.img2),
            data("mr.queen", R.drawable.img3),
            data("whats wrong with secertary kim", R.drawable.img4),
            data("goblin", R.drawable.img5),
            data("my family garteful", R.drawable.img6),
            data("itaewon class", R.drawable.img7),
            data("sky castle", R.drawable.img8),
            data("vincenzo", R.drawable.img8)
        )

        val recyclerView: RecyclerView = findViewById(R.id.rec_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cardAdapter(items)
    }
}