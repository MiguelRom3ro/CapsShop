package com.itess.capsshop.data.provider

import com.itess.capsshop.data.ShoppingCar

class ShoppingCarProvider {
    companion object{
        private val shoppingCarList = mutableListOf<ShoppingCar>()

        fun getShoppingCarList() : List<ShoppingCar>{
            return shoppingCarList
        }

        fun addProduct(id : Int, amount : Int){
            val index = shoppingCarList.indexOfFirst{it.idProduct == id}
            val itemProduct = ProductProvider.getProduct(id)
            if(index == -1){
                if (itemProduct != null) {
                    if(itemProduct.onSale){
                        val price = itemProduct.price - (itemProduct.price * (itemProduct.discount / 100))
                        val item = ShoppingCar(
                            id,
                            itemProduct.name,
                            price,
                            amount,
                            itemProduct.img
                        )
                        shoppingCarList.add(item)
                    }else{
                        val item = ShoppingCar(
                            id,
                            itemProduct.name,
                            itemProduct.price,
                            amount,
                            itemProduct.img
                        )
                        shoppingCarList.add(item)
                    }
                }
            }else{
                val cantidad = amount + shoppingCarList[index].amount
                if(cantidad > 10){
                    shoppingCarList[index].amount = 10
                }else{
                    shoppingCarList[index].amount += amount
                }
            }
        }

        fun deleteProduct(item : ShoppingCar){
            shoppingCarList.remove(item)
        }

        fun plusAmount(item : ShoppingCar) : Boolean{
            val index = shoppingCarList.indexOf(item)
            return if(shoppingCarList[index].amount != 10){
                shoppingCarList[index].amount++
                true
            }else{
                false
            }
        }

        fun substractAmount(item : ShoppingCar) : Boolean{
            val index = shoppingCarList.indexOf(item)
            return if(shoppingCarList[index].amount != 1){
                shoppingCarList[index].amount--
                true
            }else{
                false
            }
        }

        fun priceTotal(): Double{
            var total = 0.0
            for(products in shoppingCarList){
                total += (products.price * products.amount)
            }
            return total
        }

        fun getSize() : Int = shoppingCarList.size

        fun getAmount() : Int{
            var amount = 0
            for(products in shoppingCarList){
                amount += products.amount
            }
            return amount
        }

        fun clearShoppingCarList(){
            shoppingCarList.clear()
        }

        fun getFirstItem() : ShoppingCar{
            return shoppingCarList[0]
        }
    }
}