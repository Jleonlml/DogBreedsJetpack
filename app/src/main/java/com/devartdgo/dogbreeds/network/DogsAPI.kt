package com.devartdgo.dogbreeds.network

import com.devartdgo.dogbreeds.model.BreedsResponse
import com.devartdgo.dogbreeds.model.DogBreedImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsAPI {
    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BreedsResponse

    @GET("breed/{breed}/images")
    suspend fun getDogBreedImages(@Path("breed") breed: String): DogBreedImageResponse
}