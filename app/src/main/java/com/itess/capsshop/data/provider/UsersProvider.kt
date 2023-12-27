package com.itess.capsshop.data.provider

import com.itess.capsshop.data.User

class UsersProvider {
    companion object{
        private val userList = mutableListOf<User>(
            User(
                0,
                "user",
                "example",
                "user",
                "user@gmail.com",
                "User123?"
            )
        )

        private var online = false
        private var id = -1

        fun isOnline() : Boolean{
            return online
        }

        fun addUser(user : User){
            userList.add(user)
        }

        fun userExistByNameUser(nameUser : String) : Boolean {
            return userList.any { it.nameUser == nameUser }
        }

        private fun findUser(nameOrEmail: String, password: String): User? {
            return userList.find { (it.nameUser == nameOrEmail && it.password == password) || (it.email == nameOrEmail && it.password == password) }
        }

        fun logIn(nameOrEmail: String, password: String): Boolean {
            val user = findUser(nameOrEmail, password)
            return if(user != null){
                id = user.id
                online = true
                true
            }else{
                false
            }
        }

        fun getSize() : Int = userList.size

    }
}