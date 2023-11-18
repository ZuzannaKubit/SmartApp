package com.zuzob00l.smartapp.screens.loginScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
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
class SignUpViewModel @Inject constructor(
   private val repository: AuthRepository
): ViewModel()
{
    private var _signUpState = Channel<SignInState>()
    val uiLoadingState = _signUpState.receiveAsFlow()

    private var _userData = Channel<SignInState>()

    fun registerUser(email: String, password: String, name: String, surname: String)
            =viewModelScope.launch {
        repository.registerUser(email, password, name, surname).collect{ result ->
            when(result){
                is Resource.Success -> {
                    Log.d("Register", "success")
                    _signUpState.send(SignInState(isSuccess = "Sign in Success"))
                }
                is Resource.Loading -> {
                    Log.d("Register", "Loading")
                    _signUpState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {
                    Log.d("Register", "${result.message.toString()}")
                    _signUpState.send(SignInState(isError = result.message.toString()))
                }
            }
        }
    }
}