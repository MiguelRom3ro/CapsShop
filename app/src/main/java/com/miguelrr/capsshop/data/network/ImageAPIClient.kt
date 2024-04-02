package com.miguelrr.capsshop.data.network

import com.miguelrr.capsshop.data.model.ImageModel
import retrofit2.Response
import retrofit2.http.GET

interface ImageAPIClient {

    @GET("getAllImages.php")
    suspend fun getAllImages() : Response<List<ImageModel>>

}