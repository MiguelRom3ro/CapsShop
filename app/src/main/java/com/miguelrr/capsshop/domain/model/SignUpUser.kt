package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.model.SignUpUserModel

data class SignUpUser(
    val name : String,
    val lastname : String,
    val email : String,
    val password : String,
    val username : String
)