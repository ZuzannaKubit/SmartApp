package com.zuzob00l.smartapp.screens.loginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuzob00l.smartapp.firebaseAuth.data.AuthRepository
import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel()
{
    private var _signInState = Channel<SignInState>()
    val uiLoadingState = _signInState.receiveAsFlow()

    fun loginUser(email: String, password: String)
    =viewModelScope.launch {
        repository.loginUser(email, password).collect{ result ->
            when(result){
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Sign in Success")) }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {
                    _signInState.send(SignInState(isError = result.message.toString()))
                }
            }
        }
    }
}