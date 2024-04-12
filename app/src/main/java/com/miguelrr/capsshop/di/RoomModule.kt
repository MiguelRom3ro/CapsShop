package com.miguelrr.capsshop.di

import android.content.Context
import androidx.room.Room
import com.miguelrr.capsshop.data.database.CapDatabase
import com.miguelrr.capsshop.data.database.CapDatabase.Companion.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CAP_DATABASE_NAME = "cap_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CapDatabase::class.java, CAP_DATABASE_NAME)
            .addMigrations(MIGRATION_1_2)
            .build()

    @Singleton
    @Provides
    fun provideCapDao(db : CapDatabase) = db.getCapDao()

    @Singleton
    @Provides
    fun provideSCDao(db : CapDatabase) = db.getShoppingCarDao()
}