package com.miguelrr.capsshop.data.model

import com.miguelrr.capsshop.domain.model.LoginUser

data class LogInUserModel(
    val emailUsername : String,
    val password : String
)

fun LoginUser.toModel() = LogInUserModel(emailUsername, password)
