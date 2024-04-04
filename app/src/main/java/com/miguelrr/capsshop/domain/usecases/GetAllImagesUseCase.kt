package com.miguelrr.capsshop.domain.usecases

import com.miguelrr.capsshop.data.ImageRepository
import com.miguelrr.capsshop.domain.model.Image
import javax.inject.Inject

class GetAllImagesUseCase@Inject constructor(
    private val api : ImageRepository
) {

    suspend operator fun invoke() : List<Image>{
        return api.getImages()
    }
}