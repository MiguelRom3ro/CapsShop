package com.itess.capsshop.data.provider

class CarousellProvider {
    companion object{
        private val images = listOf(
            "https://www.newera.mx/cdn/shop/files/NEC_NBA23_Draft_1000x900_c71990a8-cad0-4a6d-a032-58af8cf5a649.jpg?v=1694799188",
            "https://www.newera.mx/cdn/shop/files/E-COMM_1000x900_MLB_CAMO_COLLECTION_720x.jpg?v=1684512749",
            "https://www.newera.mx/cdn/shop/files/NFL23_3rdDown_1000X900_0001_NFL23_3rdDown_IGGrid_57010019_1200x1200_bacc45c6-cc1d-4a07-bfa1-16aeaded9094_720x.jpg?v=1693846583",
        )

        fun getImagesList() = images
    }
}