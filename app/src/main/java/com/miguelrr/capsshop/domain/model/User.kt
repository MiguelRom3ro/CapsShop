package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.model.UserModel

data class User(
    val idUser : Int,
    val name : String,
    val lastName : String,
    val email : String,
    val username : String,
    val status : String,
    val reason : String
)

fun UserModel.toDomain() = User(idUser,name, lastname, email, username, status, reason)
