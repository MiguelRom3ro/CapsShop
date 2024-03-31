package com.miguelrr.capsshop.data

import com.miguelrr.capsshop.data.network.ImageAPIClient
import com.miguelrr.capsshop.data.network.NetworkService
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val api : NetworkService
) {

    suspend fun getImages(): List<String> {
        return api.getImages()
    }
}