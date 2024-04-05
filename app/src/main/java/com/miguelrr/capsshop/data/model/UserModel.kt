package com.miguelrr.capsshop.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("id_user") val idUser : Int,
    @SerializedName("name") val name : String,
    @SerializedName("lastname") val lastname : String,
    @SerializedName("email") val email : String,
    @SerializedName("username") val username : String,
    @SerializedName("status") val status : String,
    @SerializedName("reason") val reason : String
)