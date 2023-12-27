package com.itess.capsshop.data

data class ShoppingCar(
    val idProduct : Int,
    val name : String,
    val price : Double,
    var amount : Int,
    val img : String
)