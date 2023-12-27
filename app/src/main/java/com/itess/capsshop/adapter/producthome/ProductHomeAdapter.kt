package com.itess.capsshop.adapter.producthome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itess.capsshop.R
import com.itess.capsshop.data.Product
import com.itess.capsshop.ui.onClickListener

// Adaptador para el RecyclerView que muestra una lista de productos
class ProductHomeAdapter(
    private val products: List<Product>,
    private val listen: onClickListener) : RecyclerView.Adapter<ProductHomeViewHolder>() {

    // Función llamada cuando el RecyclerView necesita crear un nuevo ViewHolder para mostrar un elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHomeViewHolder {
        // Inflar el diseño del elemento de producto desde XML usando un LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Devolver un nuevo ProductoViewHolder que contiene la vista inflada
        return ProductHomeViewHolder(layoutInflater.inflate(R.layout.view_horizontal_product, parent, false), listen)
    }

    // Función que devuelve la cantidad total de elementos en el conjunto de datos
    override fun getItemCount(): Int = products.size

    // Función llamada por RecyclerView para mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: ProductHomeViewHolder, position: Int) {
        // Obtener el producto en la posición específica
        val item = products[position]
        // Llamar a la función render de ProductoViewHolder para mostrar los datos en la vista
        holder.render(item)
    }
}