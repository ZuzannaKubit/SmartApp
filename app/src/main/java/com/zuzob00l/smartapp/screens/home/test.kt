package com.zuzob00l.smartapp.screens.home

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Test(viewModel: HomeViewModel = hiltViewModel()) {
    Button(onClick = { viewModel.loadImages()})
    {

    }
}