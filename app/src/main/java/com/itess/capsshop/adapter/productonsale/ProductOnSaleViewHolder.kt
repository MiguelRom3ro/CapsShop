package com.itess.capsshop.adapter.productonsale

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itess.capsshop.data.Product
import com.itess.capsshop.data.provider.ShoppingCarProvider
import com.itess.capsshop.databinding.ViewSalesProductBinding
import com.itess.capsshop.ui.onClickListener

// ViewHolder que representa un elemento individual dentro del RecyclerView
class ProductOnSaleViewHolder(view: View, private val listen : onClickListener) : RecyclerView.ViewHolder(view) {

    val binding = ViewSalesProductBinding.bind(view)

    fun render(productOnSaleModel: Product) {

        val priceOnSale = productOnSaleModel.price - (productOnSaleModel.price * productOnSaleModel.discount / 100)

        binding.tvNameProductSales.text = productOnSaleModel.name
        "$${productOnSaleModel.price}".also { binding.tvSalesBeforePrice.text = it }
        "$$priceOnSale".also { binding.tvSalesPrice.text = it }
        "%${productOnSaleModel.discount}".also { binding.tvSalesDiscount.text = it }
        Glide.with(binding.ivSalesProduct.context).load(productOnSaleModel.img).into(binding.ivSalesProduct)

        binding.cardSales.setOnClickListener {
            setListener(productOnSaleModel.id)
        }

        binding.btnSalesAddCar.setOnClickListener{
            ShoppingCarProvider.addProduct(productOnSaleModel.id, 1)
            Toast.makeText(binding.ivSalesProduct.context, "Agregado con exito", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListener(id: Int){
        listen.onClickProduct(id)
    }

}