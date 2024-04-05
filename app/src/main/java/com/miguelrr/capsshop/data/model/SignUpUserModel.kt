package com.miguelrr.capsshop.data.model

import com.miguelrr.capsshop.domain.model.SignUpUser

data class SignUpUserModel(
    val name : String,
    val lastname : String,
    val email : String,
    val password : String,
    val username : String
)

fun SignUpUser.toModel() = SignUpUserModel(name, lastname, email, password, username)
