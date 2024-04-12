package com.miguelrr.capsshop.ui.adapter.shoppingcar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelrr.capsshop.R
import com.miguelrr.capsshop.domain.listeners.GetCapIdListener
import com.miguelrr.capsshop.domain.listeners.OnClickSearch
import com.miguelrr.capsshop.domain.listeners.OnClickShoppingCar
import com.miguelrr.capsshop.domain.model.Cap
import com.miguelrr.capsshop.domain.model.ShoppingCar
import com.miguelrr.capsshop.ui.adapter.search.SearchViewHolder

class ShoppingCarAdapter (
    private val listSC: List<ShoppingCar>,
    private val listen: OnClickShoppingCar,
    private val listenGetCap : GetCapIdListener
) : RecyclerView.Adapter<ShoppingCarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShoppingCarViewHolder(layoutInflater.inflate(R.layout.view_shopping_car_card, parent, false), listen, listenGetCap)
    }

    override fun onBindViewHolder(holder: ShoppingCarViewHolder, position: Int) {
        val item = listSC[position]

        holder.render(item)
    }

    override fun getItemCount(): Int = listSC.size

}