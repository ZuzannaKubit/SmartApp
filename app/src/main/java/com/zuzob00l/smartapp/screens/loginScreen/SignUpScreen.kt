package com.zuzob00l.smartapp.screens.loginScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.components.EmailTextField
import com.zuzob00l.smartapp.components.PasswordField
import com.zuzob00l.smartapp.components.SubmitButton
import com.zuzob00l.smartapp.components.UserDataTextField
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navController: NavController,
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    popUpScreen: () -> Unit)
{
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val repeatedPassword = rememberSaveable { mutableStateOf("") }
    val name = rememberSaveable { mutableStateOf("") }
    val surname = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val state = signUpViewModel.uiLoadingState.collectAsState(initial = null)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Header()
        RegisterTextField(
            name = name,
            surname = surname,
            email = email,
            password = password,
            repeatedPassword = repeatedPassword)
        RegisterButton(
            onRegisterClicked = {
                scope.launch {
                signUpViewModel.registerUser(
                    email = email.value,
                    name = name.value,
                    surname = surname.value,
                    password = password.value,)
            } },)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        )
        {
            if (state.value?.isLoading == true) {
                CircularProgressIndicator(color = Color.Yellow)
            }
        }
        LaunchedEffect(key1 = state.value?.isSuccess) {
            scope.launch {
                if (state.value?.isSuccess?.isNotEmpty() == true) {
                    val success = state.value?.isSuccess
                    Toast.makeText(context, "${success}", Toast.LENGTH_LONG).show()
                    popUpScreen()
                }
            }
        }

        LaunchedEffect(key1 = state.value?.isError) {
            scope.launch {
                if (state.value?.isError?.isNotEmpty() == true) {
                    val error = state.value?.isError
                    Toast.makeText(context, "${error}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
@Composable
fun RegisterButton(
    onRegisterClicked: () -> Unit)
{
    SubmitButton(
        text = stringResource(R.string.zarejestruj_sie),
        onDone = { onRegisterClicked() })
}
@Composable
fun RegisterTextField(
    name: MutableState<String>,
    surname: MutableState<String>,
    email: MutableState<String>,
    password: MutableState<String>,
    repeatedPassword: MutableState<String>)
{
    UserDataTextField(
        userDataState = name,
        placeholder = stringResource(R.string.imie))
    Spacer(modifier = Modifier.height(8.dp))

    UserDataTextField(
        userDataState = surname,
        placeholder = stringResource(R.string.nazwisko))
    Spacer(modifier = Modifier.height(8.dp))

    EmailTextField(emailState = email)
    Spacer(modifier = Modifier.height(8.dp))

    PasswordField(passwordState = password, placeholder = stringResource(R.string.haslo))
    Spacer(modifier = Modifier.height(8.dp))
    PasswordField(passwordState = repeatedPassword, placeholder = stringResource(R.string.powtorz_haslo))
}
@Composable
fun Header()
{
    Text(
        text = stringResource(R.string.zarejestruj_sie),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold)
}
