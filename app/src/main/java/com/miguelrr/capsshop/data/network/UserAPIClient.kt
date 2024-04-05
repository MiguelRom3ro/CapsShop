package com.miguelrr.capsshop.data.network

import com.miguelrr.capsshop.data.model.ResponseSignUpModel
import com.miguelrr.capsshop.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPIClient {

    @GET("signUpUser.php")
    suspend fun signUpUser(
        @Query("name") name : String,
        @Query("lastname") lastname : String,
        @Query("email") email : String,
        @Query("password") password : String,
        @Query("username") username : String
    ) : Response<ResponseSignUpModel>

    @GET("loginUser.php")
    suspend fun logInUser(
        @Query("email_username") emailUsername : String,
        @Query("password") password: String
    ) : Response<UserModel>

    @GET("getUserByID.php")
    suspend fun searchUserById(
        @Query("id_user") idUser : Int
    ) : Response<UserModel>
}