package com.miguelrr.capsshop.data.network

import com.miguelrr.capsshop.data.model.CapModel
import retrofit2.Response
import retrofit2.http.GET

interface CapAPIClient {

    @GET
    suspend fun getAllCaps() : Response<List<CapModel>>
}