package com.devartdgo.dogbreeds.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devartdgo.dogbreeds.data.DataOrException
import com.devartdgo.dogbreeds.model.Breeds
import com.devartdgo.dogbreeds.model.BreedsResponse
import com.devartdgo.dogbreeds.repository.DogBreedsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

@HiltViewModel
class DogBreedsViewModel @Inject constructor(private val repository: DogBreedsRepository): ViewModel() {
    val data: MutableState<DataOrException<List<String>, Boolean, Exception>> =
        mutableStateOf(DataOrException(emptyList(), true, Exception("")))

    init {
        getAllBreeds()
    }

    private fun getAllBreeds() {
        viewModelScope.launch {
            data.value = repository.getAllBreeds()
        }
    }
}