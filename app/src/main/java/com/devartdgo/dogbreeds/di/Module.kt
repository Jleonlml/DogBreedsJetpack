package com.devartdgo.dogbreeds.di

import com.devartdgo.dogbreeds.constants.Constants
import com.devartdgo.dogbreeds.network.DogsAPI
import com.devartdgo.dogbreeds.repository.DogBreedsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Singleton
    @Provides
    fun providesRepository(api: DogsAPI) = DogBreedsRepository(api)

    @Singleton
    @Provides
    fun providesApi() : DogsAPI
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogsAPI::class.java)
    }
}