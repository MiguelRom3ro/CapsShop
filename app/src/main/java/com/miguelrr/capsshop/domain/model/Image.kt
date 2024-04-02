package com.miguelrr.capsshop.domain.model

import com.miguelrr.capsshop.data.model.ImageModel

data class Image(
    val image : String
)

fun ImageModel.toDomain() = Image(images)
