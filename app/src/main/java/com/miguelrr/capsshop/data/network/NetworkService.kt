package com.miguelrr.capsshop.data.network

import com.miguelrr.capsshop.data.model.CapModel
import com.miguelrr.capsshop.data.model.ImageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkService @Inject constructor(
    private val api : CapAPIClient,
    private val apiImages : ImageAPIClient){

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
}