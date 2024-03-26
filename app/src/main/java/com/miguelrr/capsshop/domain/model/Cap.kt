package com.miguelrr.capsshop.domain.model

data class Cap(
    val id : Int,
    val name : String,
    val category : String,
    val price : Double,
    val discount : Double,
    val description : String,
    val image : String
)