package com.miguelrr.capsshop.data.model

import com.google.gson.annotations.SerializedName

data class ResponseSignUpModel(
    @SerializedName("status") val status : String,
    @SerializedName("reason") val reason : String
)