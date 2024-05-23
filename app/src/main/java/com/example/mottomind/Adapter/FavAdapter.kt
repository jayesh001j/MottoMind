package com.example.soulscript.Adapter

import Qoutes_moden
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mottomind.R

class FavAdapter(private val context: Context, private val favList: List<Qoutes_moden>) :
    RecyclerView.Adapter<FavAdapter.FavHolder>() {

    inner class FavHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Quotestext: TextView = itemView.findViewById(R.id.Quotestext)
        var authorName: TextView = itemView.findViewById(R.id.authirname)
        var Add_favorite: ImageView = itemView.findViewById(R.id.Add_favorite)
        // Add other views as needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fav_item, parent, false)
        return FavHolder(view)
    }

    override fun getItemCount(): Int {
        return favList.size
    }

    override fun onBindViewHolder(holder: FavHolder, position: Int) {
        val currentItem = favList[position]
        holder.Quotestext.text = currentItem.quotes
        holder.authorName.text = currentItem.authorName
        holder.Add_favorite.setImageResource(R.drawable.add_icon)
        holder.Add_favorite.setOnClickListener {
            val intent = Intent(context, Qoutes_moden::class.java)
            intent.putExtra("Quotes", favList[position].quotes)
            intent.putExtra("Author", favList[position].authorName)
            context.startActivity(intent)

        }


    }
}
