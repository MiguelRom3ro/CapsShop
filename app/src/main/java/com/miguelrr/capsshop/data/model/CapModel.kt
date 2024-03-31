package com.miguelrr.capsshop.data.model

import com.google.gson.annotations.SerializedName

data class CapModel(
    @SerializedName("id_cap") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("category") val category : String,
    @SerializedName("price") val price : Double,
    @SerializedName("discount") val discount : Double,
    @SerializedName("description") val description : String,
    @SerializedName("image") val image : String
)
