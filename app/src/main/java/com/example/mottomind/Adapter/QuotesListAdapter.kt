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
import com.example.soulscript.DbHelper

class QuotesListAdapter(val context: Context, val quotesList: ArrayList<Qoutes_moden>) :
    RecyclerView.Adapter<QuotesListAdapter.QuotesHolder>() {

    private var onLikeClickListener: OnLikeClickListener? = null
    private val dbHelper = DbHelper(context) // Initialize DbHelper here

    interface OnLikeClickListener {
        fun onLikeClick(position: Int)
    }

    fun setOnLikeClickListener(listener: OnLikeClickListener) {
        this.onLikeClickListener = listener
    }

    class QuotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quotesText: TextView = itemView.findViewById(R.id.Quotestext)
        var authorName: TextView = itemView.findViewById(R.id.authirname)
        var Add_favorite: ImageView = itemView.findViewById(R.id.Add_favorite)
        var quotes_share: ImageView = itemView.findViewById(R.id.quotes_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.qoutes_list, parent, false)
        return QuotesHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
        val currentItem: Qoutes_moden = quotesList[position]

        holder.quotesText.text = currentItem.quotes
        holder.authorName.text = currentItem.authorName
        holder.Add_favorite.setImageResource(R.drawable.add_icon)

        if (currentItem.liked) {
            holder.Add_favorite.setImageResource(R.drawable.ic_favorite_red_24dp)
        } else {
            holder.Add_favorite.setImageResource(R.drawable.add_icon)
        }

        holder.Add_favorite.setOnClickListener {

            val newLikedState = !currentItem.liked
//            dbHelper.updateLikedStatus(currentItem.boolean, newLikedState)
            currentItem.liked = newLikedState
            notifyItemChanged(position)
            onLikeClickListener?.onLikeClick(position)
        }

        holder.quotes_share.setOnClickListener {
            val quoteText = currentItem.quotes

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, quoteText)
            context.startActivity(Intent.createChooser(shareIntent, "Share using"))
        }
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}
