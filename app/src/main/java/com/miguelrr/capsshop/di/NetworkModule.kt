package com.miguelrr.capsshop.di

import com.miguelrr.capsshop.data.network.CapAPIClient
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

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://arduinotomobile.000webhostapp.com/php/CapsShop/getAllData.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCapApiClient(retrofit: Retrofit) : CapAPIClient{
        return retrofit.create(CapAPIClient::class.java)
    }
}