package com.example.sesion10_11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type

class AlbumAdapter (private var listalbum: List<Album>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textid = itemView.findViewById<TextView>(R.id.txtid)
        val texttitulo = itemView.findViewById<TextView>(R.id.txttitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return listalbum.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item:Album = listalbum[position]
        holder.textid.text = item.id.toString()
        holder.texttitulo.text = item.title
    }


}