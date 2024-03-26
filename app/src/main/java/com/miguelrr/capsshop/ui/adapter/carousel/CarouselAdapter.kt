package com.miguelrr.capsshop.ui.adapter.carousel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelrr.capsshop.R

class CarouselAdapter(private val images: List<String>) : RecyclerView.Adapter<CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarouselViewHolder(layoutInflater.inflate(R.layout.view_carousel, parent, false))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = images[position]

        holder.render(item)
    }
}