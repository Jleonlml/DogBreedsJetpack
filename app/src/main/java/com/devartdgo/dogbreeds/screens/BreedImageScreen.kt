package com.devartdgo.dogbreeds.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.devartdgo.dogbreeds.viewmodel.DogBreedImageViewModel
import com.devartdgo.dogbreeds.viewmodel.DogBreedsViewModel

@Composable
fun BreedImageScreen(navController: NavController, breed: String?, viewModel: DogBreedImageViewModel = hiltViewModel()) {
    if (breed != null) {
        viewModel.getDogBreedImages(breed = breed)
        Image(
            painter = rememberAsyncImagePainter(viewModel.data.value.data?.message?.get(0)),
            contentDescription = null,
        )
    }
}