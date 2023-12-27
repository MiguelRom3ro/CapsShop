package com.itess.capsshop.adapter.productonsale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itess.capsshop.R
import com.itess.capsshop.data.Product
import com.itess.capsshop.ui.onClickListener

// Adaptador para el RecyclerView que muestra una lista de productos
class ProductOnSaleAdapter(
    private val productsOnSale: List<Product>,
    private val listen: onClickListener
) : RecyclerView.Adapter<ProductOnSaleViewHolder>() {

    // Función llamada cuando el RecyclerView necesita crear un nuevo ViewHolder para mostrar un elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOnSaleViewHolder {
        // Inflar el diseño del elemento de producto desde XML usando un LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Devolver un nuevo ProductoViewHolder que contiene la vista inflada
        return ProductOnSaleViewHolder(layoutInflater.inflate(R.layout.view_sales_product, parent, false), listen)
    }

    // Función que devuelve la cantidad total de elementos en el conjunto de datos
    override fun getItemCount(): Int = productsOnSale.size

    // Función llamada por RecyclerView para mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: ProductOnSaleViewHolder, position: Int) {
        // Obtener el producto en la posición específica
        val item = productsOnSale[position]
        // Llamar a la función render de ProductoViewHolder para mostrar los datos en la vista
        holder.render(item)
    }
}