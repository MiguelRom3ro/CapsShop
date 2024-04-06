package com.miguelrr.capsshop.domain

import android.content.Context

class IdUserSharedPreferences(context : Context) {

    val SHARED_NAME = "IdUserDB"
    val SHARED_ID = "IdUser"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveId(idUser : Int){
        storage.edit().putInt(SHARED_ID, idUser).apply()
    }

    fun getId() : Int{
        return storage.getInt(SHARED_ID, -1)
    }

    fun logOut(){
        storage.edit().putInt(SHARED_ID, -1).apply()
    }
}