package com.miguelrr.capsshop.ui.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelrr.capsshop.R
import com.miguelrr.capsshop.domain.listeners.OnClickHorizontal
import com.miguelrr.capsshop.domain.listeners.OnClickSearch
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.ui.adapter.horizontal.HorizontalViewHolder

class SearchAdapter (
    private val caps: List<Cap>,
    private val listen : OnClickSearch
) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(layoutInflater.inflate(R.layout.view_search_card, parent, false), listen)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = caps[position]

        holder.render(item)
    }

    override fun getItemCount(): Int = caps.size

}