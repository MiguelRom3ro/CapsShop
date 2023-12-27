package com.itess.capsshop.adapter.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itess.capsshop.R
import com.itess.capsshop.data.Product
import com.itess.capsshop.ui.onClickListener

class ProductAdapter(
    private val products: List<Product>,
    private val listen: onClickListener
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.view_vertical_product, parent, false), listen)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]

        holder.render(item)
    }
}
