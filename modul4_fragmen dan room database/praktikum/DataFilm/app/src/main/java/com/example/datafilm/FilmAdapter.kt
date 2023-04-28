package com.example.datafilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datafilm.data.Film
import com.example.datafilm.databinding.ItemFilmBinding

class FilmAdapter(var list: List<Film>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }

    interface Dialog{
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding: ItemFilmBinding = ItemFilmBinding.bind(view)

        init {
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val films = list[position]
        holder.binding.textId.text = films.id.toString()
        holder.binding.textJudul.text = films.judul
        holder.binding.textTahun.text = films.tahun
    }
}