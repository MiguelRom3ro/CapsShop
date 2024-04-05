package com.miguelrr.capsshop.di

import com.miguelrr.capsshop.data.network.CapAPIClient
import com.miguelrr.capsshop.data.network.ImageAPIClient
import com.miguelrr.capsshop.data.network.UserAPIClient
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
            .baseUrl("https://arduinotomobile.000webhostapp.com/php/CapsShop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCapApiClient(retrofit: Retrofit) : CapAPIClient{
        return retrofit.create(CapAPIClient::class.java)
    }

    @Singleton
    @Provides
    fun provideImageApiClient(retrofit: Retrofit) : ImageAPIClient{
        return retrofit.create(ImageAPIClient::class.java)
    }

    @Singleton
    @Provides
    fun provideUserApiClient(retrofit: Retrofit) : UserAPIClient{
        return retrofit.create(UserAPIClient::class.java)
    }
}