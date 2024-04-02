package com.miguelrr.capsshop.di

import android.util.Log
import com.miguelrr.capsshop.data.network.CapAPIClient
import com.miguelrr.capsshop.data.network.ImageAPIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://arduinotomobile.000webhostapp.com/php/CapsShop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCapApiClient(retrofit: Retrofit) : CapAPIClient{
        Log.d("Pruebas", "Retrofit1........................")
        return retrofit.create(CapAPIClient::class.java)
    }

    @Provides
    fun provideImageApiClient(retrofit: Retrofit) : ImageAPIClient{
        Log.d("Pruebas", "Retrofit2........................")
        return retrofit.create(ImageAPIClient::class.java)
    }
}