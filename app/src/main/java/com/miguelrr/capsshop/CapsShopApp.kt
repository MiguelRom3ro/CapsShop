package com.miguelrr.capsshop

import android.app.Application
import com.miguelrr.capsshop.domain.IdUserSharedPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CapsShopApp : Application(){

    companion object{
        lateinit var idUserSP : IdUserSharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        idUserSP = IdUserSharedPreferences(applicationContext)
    }
}