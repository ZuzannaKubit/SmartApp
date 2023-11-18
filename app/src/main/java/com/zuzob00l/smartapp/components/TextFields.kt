package com.zuzob00l.smartapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.modifiers.textFieldsModifier

@Composable
fun EmailTextField(
    modifier : Modifier = Modifier,
    emailState: MutableState<String>,
    enabled: Boolean = true,
    singleLine: Boolean = true)
{
     OutlinedTextField(
         modifier = Modifier.textFieldsModifier(),
         value = emailState.value,
         onValueChange = { emailState.value = it },
         leadingIcon = { Icon(
             imageVector = Icons.Default.Email,
             contentDescription = "email") },
         textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
         placeholder = {Text("Enter Your Email Here...", color = Color.Gray) },
         shape = RoundedCornerShape(10),
         colors = TextFieldDefaults.outlinedTextFieldColors(
             focusedBorderColor = Color.Yellow,
             leadingIconColor = Color.Gray,
             backgroundColor = Color.Transparent)
     )
}
@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    placeholder: String = "password",
    passwordState: MutableState<String>)
{
   PasswordTextField(
       passwordState = passwordState,
       placeholder = placeholder,
       modifier = Modifier.textFieldsModifier())
}

@Composable
private fun PasswordTextField(
    modifier: Modifier = Modifier,
    passwordState: MutableState<String>,
    placeholder: String)
{
    var visibility by remember { mutableStateOf(false) }
    val passwordIcon = if(visibility) painterResource(R.drawable.ic_visibility_off)
                       else painterResource(R.drawable.ic_visibility_on)

    val visualTransformation = if(visibility) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = modifier,
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        placeholder = { Text(text = placeholder) },
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "password leadingIcon") },
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    painter = passwordIcon,
                    contentDescription = "password trailing icon")
        }},
        textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Yellow,
            leadingIconColor = Color.Gray,
            backgroundColor = Color.Transparent)
    )
}
@Composable
fun UserDataTextField(
    modifier: Modifier = Modifier,
    userDataState: MutableState<String>,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    placeholder: String)
{
    OutlinedTextField(
        modifier = Modifier.textFieldsModifier(),
        value = userDataState.value,
        onValueChange = {userDataState.value = it},
        leadingIcon = { Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null)},
        textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Transparent,
            focusedBorderColor = Color.Yellow,
            leadingIconColor = Color.Gray
        )
    )
}

