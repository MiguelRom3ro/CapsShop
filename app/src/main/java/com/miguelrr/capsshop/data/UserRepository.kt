package com.miguelrr.capsshop.data

import com.miguelrr.capsshop.data.model.SignUpUserModel
import com.miguelrr.capsshop.data.model.toModel
import com.miguelrr.capsshop.data.network.NetworkService
import com.miguelrr.capsshop.domain.model.LoginUser
import com.miguelrr.capsshop.domain.model.ResponseSignUp
import com.miguelrr.capsshop.domain.model.SignUpUser
import com.miguelrr.capsshop.domain.model.User
import com.miguelrr.capsshop.domain.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api : NetworkService
) {

    suspend fun signUp(signUpUser: SignUpUser) : ResponseSignUp{
        val signUpUserModel = signUpUser.toModel()
        val response = api.signUpUser(signUpUserModel)
        return response.toDomain()
    }

    suspend fun logIn(loginUser: LoginUser) : User{
        val loginUserModel = loginUser.toModel()
        val response = api.loginUser(loginUserModel)
        return response.toDomain()
    }

    suspend fun searchById(idUser : Int) : User{
        val response = api.searchUserById(idUser)
        return response.toDomain()
    }
}