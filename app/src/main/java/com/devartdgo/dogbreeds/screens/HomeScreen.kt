package com.devartdgo.dogbreeds.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devartdgo.dogbreeds.R
import com.devartdgo.dogbreeds.navigation.AppScreens
import com.devartdgo.dogbreeds.viewmodel.DogBreedsViewModel

@Composable
fun HomeScreen(navController: NavController) {
    BreedsList(navController)
}

@Composable
fun BreedsList(navController: NavController, modifier: Modifier = Modifier, viewModel : DogBreedsViewModel = hiltViewModel()) {
    if (viewModel.data.value.data != null) {
        LazyColumn() {
            items(items = viewModel.data.value.data!!) { breed ->
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable {
                            navController.navigate(AppScreens.BreedImageScreen.name + "/" + breed)
                        },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.teal_200)
                    )
                ) {
                    Column(
                        modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = breed
                        )
                    }
                }
            }
        }
    }
}
