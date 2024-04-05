package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.model.ResponseSignUpModel

data class ResponseSignUp(
    val status : String,
    val reason : String
)

fun ResponseSignUpModel.toDomain() = ResponseSignUp(status, reason)