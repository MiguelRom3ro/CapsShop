package com.itess.capsshop.data

data class Product(
    val id : Int,
    val name:String,
    val category : CategoryCaps,
    val onSale : Boolean,
    val discount : Int,
    val description:String,
    val price: Double,
    val img:String
)
