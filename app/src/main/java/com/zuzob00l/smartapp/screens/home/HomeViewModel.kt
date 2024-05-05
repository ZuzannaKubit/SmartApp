package com.zuzob00l.smartapp.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuzob00l.smartapp.firebaseAuth.data.StorageRepository
import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import com.zuzob00l.smartapp.screens.loginScreen.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val storageRepository: StorageRepository
): ViewModel()
{
    private var _loadImagesState = Channel<SignInState>()
    val loadImagesState = _loadImagesState.receiveAsFlow()

    fun loadImages() = viewModelScope.launch {
        storageRepository.getImageURIFromFirestore().collect{ result ->

            when(result)
            {
                is Resource.Success -> {
                    _loadImagesState.send(SignInState(isSuccess = "Success"))
                }
                is Resource.Loading -> {
                    _loadImagesState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {
                    _loadImagesState.send(SignInState(isError = result.message.toString()))
                }
            }

        }
    }
}