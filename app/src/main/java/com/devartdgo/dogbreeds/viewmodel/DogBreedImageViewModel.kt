package com.devartdgo.dogbreeds.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devartdgo.dogbreeds.data.DataOrException
import com.devartdgo.dogbreeds.model.DogBreedImageResponse
import com.devartdgo.dogbreeds.repository.DogBreedsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedImageViewModel @Inject constructor(private val repository: DogBreedsRepository): ViewModel() {
    val data: MutableState<DataOrException<DogBreedImageResponse, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    fun getDogBreedImages(breed: String) {
        viewModelScope.launch {
            data.value = repository.getDogBreedImages(breed)
        }
    }
}