package com.miguelrr.capsshop.domain.listeners

interface OnClickShoppingCar {

    fun onClickUpdate(amount : Int, id : Int)

    fun onClickRemove(id: Int)
}