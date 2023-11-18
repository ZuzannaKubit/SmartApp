package com.zuzob00l.smartapp.screens.loginScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.components.EmailTextField
import com.zuzob00l.smartapp.components.LogInMessageText
import com.zuzob00l.smartapp.components.MessageText
import com.zuzob00l.smartapp.components.PasswordField
import com.zuzob00l.smartapp.components.SubmitButton
import com.zuzob00l.smartapp.navigation.SmartAppScreens
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
)
{
    LoginScreenContent(
        viewModel = viewModel,
        popUpScreen = { navController.navigate(SmartAppScreens.HomeScreen.name) },
        onRegisterClick = {navController.navigate(SmartAppScreens.RegisterScreen.name)})
}

@Composable
fun LoginScreenContent(
    viewModel: SignInViewModel,
    popUpScreen:() -> Unit,
    onRegisterClick: () -> Unit)
{
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val state = viewModel.uiLoadingState.collectAsState(initial = null)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(130.dp),
            painter = painterResource(R.drawable.ic_logo_yellow),
            contentDescription = "logo image")

        LogInMessageText()

        EmailTextField(emailState = email)
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(passwordState = password)

        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
            text = stringResource(R.string.nie_masz_konta),
            fontSize = 18.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Normal
        )
        Text(
            modifier = Modifier
                .padding(start = 3.dp)
                .clickable { onRegisterClick() },
            text = stringResource(R.string.zarejestruj_sie),
            fontSize = 18.sp,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold
        )

        SubmitButton(
            text = stringResource(R.string.Zaloguj_się),
            onDone = {
                scope.launch {
                    viewModel.loginUser(email.value, password.value)
                }
            })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.Center
        )
        {
            if (state.value?.isLoading == true) {
                CircularProgressIndicator(color = Color.Yellow)
            }
        }
        //MessageText(text = R.string.Nieprawidłowy_Email_lub_Hasło)

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

