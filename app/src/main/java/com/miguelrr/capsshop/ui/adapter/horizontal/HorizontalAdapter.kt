package com.miguelrr.capsshop.ui.adapter.horizontal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelrr.capsshop.R
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.ui.adapter.carousel.CarouselViewHolder

class HorizontalAdapter(private val nbaCaps: List<Cap>) : RecyclerView.Adapter<HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HorizontalViewHolder(layoutInflater.inflate(R.layout.view_horizontal_card, parent, false))
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = nbaCaps[position]

        holder.render(item)
    }

    override fun getItemCount(): Int = nbaCaps.size

}