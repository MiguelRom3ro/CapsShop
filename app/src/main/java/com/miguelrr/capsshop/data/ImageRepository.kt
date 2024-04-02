package com.miguelrr.capsshop.data

import com.miguelrr.capsshop.data.network.ImageAPIClient
import com.miguelrr.capsshop.data.network.NetworkService
import com.miguelrr.capsshop.domain.model.Image
import com.miguelrr.capsshop.domain.model.toDomain
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val api : NetworkService
) {

    suspend fun getImages(): List<Image> {
        val response = api.getImages()
        return response.map { it.toDomain() }
    }
}