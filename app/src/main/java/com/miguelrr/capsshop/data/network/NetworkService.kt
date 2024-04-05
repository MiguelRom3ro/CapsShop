package com.miguelrr.capsshop.data.network

import com.miguelrr.capsshop.data.model.CapModel
import com.miguelrr.capsshop.data.model.ImageModel
import com.miguelrr.capsshop.data.model.LogInUserModel
import com.miguelrr.capsshop.data.model.ResponseSignUpModel
import com.miguelrr.capsshop.data.model.SignUpUserModel
import com.miguelrr.capsshop.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkService @Inject constructor(
    private val api : CapAPIClient,
    private val apiImages : ImageAPIClient,
    private val apiUser : UserAPIClient){

    suspend fun getCaps() : List<CapModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllCaps()
            response.body() ?: emptyList()
        }
    }

    suspend fun getImages() : List<ImageModel>{
        return withContext(Dispatchers.IO){
            val response = apiImages.getAllImages()
            response.body() ?: emptyList()
        }
    }

    suspend fun signUpUser(signUpUserModel: SignUpUserModel) : ResponseSignUpModel{
        return withContext(Dispatchers.IO){
            val response = apiUser.signUpUser(
                signUpUserModel.name,
                signUpUserModel.lastname,
                signUpUserModel.email,
                signUpUserModel.password,
                signUpUserModel.lastname
            )
            response.body()?: ResponseSignUpModel("error", "not data found")
        }
    }

    suspend fun loginUser(logInUserModel: LogInUserModel) : UserModel{
        return withContext(Dispatchers.IO){
            val response = apiUser.logInUser(
                logInUserModel.emailUsername,
                logInUserModel.password
            )
            response.body() ?: UserModel(
                -1,
                "",
                "",
                "",
                "",
                "error",
                "Usuario no encontrado"
            )
        }
    }

    suspend fun searchUserById(idUser : Int) : UserModel{
        return withContext(Dispatchers.IO){
            val response = apiUser.searchUserById(idUser)
            response.body() ?: UserModel(
                -1,
                "",
                "",
                "",
                "",
                "error",
                "Usuario no encontrado"
            )
        }
    }
}