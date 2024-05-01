package com.devartdgo.dogbreeds.repository

import com.devartdgo.dogbreeds.data.DataOrException
import com.devartdgo.dogbreeds.model.BreedsResponse
import com.devartdgo.dogbreeds.model.DogBreedImageResponse
import com.devartdgo.dogbreeds.network.DogsAPI
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

class DogBreedsRepository @Inject constructor(private val api: DogsAPI) {
    suspend fun getAllBreeds(): DataOrException<List<String>, Boolean, Exception> {
        val dataOrException = DataOrException<List<String>, Boolean, Exception>()
        try {
            dataOrException.loading = true
            dataOrException.data = mapBreedsIntoList(api.getAllBreeds())
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
        }

        return dataOrException
    }

    private fun mapBreedsIntoList(data: BreedsResponse): List<String> {
        return data.message::class.memberProperties.map {
            it.name
        }.toList()
    }

    suspend fun getDogBreedImages(breed: String): DataOrException<DogBreedImageResponse, Boolean, Exception> {
        val dataOrException = DataOrException<DogBreedImageResponse, Boolean, Exception>()
        try {
            dataOrException.loading = true
            dataOrException.data = api.getDogBreedImages(breed)
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
        }

        return dataOrException
    }
}