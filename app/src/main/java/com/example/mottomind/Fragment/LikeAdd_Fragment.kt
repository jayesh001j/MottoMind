package com.example.soulscript.Fragment

import Qoutes_moden
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mottomind.R
import com.example.soulscript.Adapter.QuotesListAdapter

class LikeAdd_Fragment : Fragment(), QuotesListAdapter.OnLikeClickListener {

    private lateinit var quotesList: ArrayList<Qoutes_moden>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_like_add, container, false)

        quotesList = ArrayList()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = QuotesListAdapter(requireContext(), quotesList)
        adapter.setOnLikeClickListener(this)
        recyclerView.adapter = adapter

        return view
    }

    override fun onLikeClick(position: Int) {
        val quote = quotesList[position]
    }
}
