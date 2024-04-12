package com.miguelrr.capsshop.ui.adapter.shoppingcar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelrr.capsshop.databinding.ViewShoppingCarCardBinding
import com.miguelrr.capsshop.domain.listeners.GetCapIdListener
import com.miguelrr.capsshop.domain.listeners.OnClickShoppingCar
import com.miguelrr.capsshop.domain.model.ShoppingCar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingCarViewHolder (view: View,
    private val listen: OnClickShoppingCar,
    private val listenGetCap : GetCapIdListener) : RecyclerView.ViewHolder(view) {

    val binding = ViewShoppingCarCardBinding.bind(view)

    fun render(item: ShoppingCar) {
        GlobalScope.launch(Dispatchers.Main) {
            val cap = listenGetCap.getCap(item.idCap)
            binding.tvShoppingCarName.text = cap.name
            "${item.amount}".also { binding.tvScAmount.text = it }
            "$${cap.price}".also { binding.tvPriceSc.text = it }
            Glide.with(binding.ivShoppingCar.context)
                .load(cap.image)
                .centerCrop()
                .into(binding.ivShoppingCar)
        }

        binding.btnScPlus.setOnClickListener{
            item.amount++
            update(item.amount, item.id)
        }

        binding.btnScSubstract.setOnClickListener{
            item.amount--
            update(item.amount, item.id)
        }

        binding.tvDelete.setOnClickListener{
            remove(item.id)
        }
    }

    private fun update(amount: Int, id: Int) {
        listen.onClickUpdate(amount, id)
    }

    private fun remove(id : Int){
        listen.onClickRemove(id)
    }
}