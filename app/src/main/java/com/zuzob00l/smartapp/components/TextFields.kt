package com.zuzob00l.smartapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import com.zuzob00l.smartapp.R

@Composable
fun EmailTextField(
    modifier : Modifier = Modifier,
    email: String,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onNewEmail: (String) -> Unit)
{
     OutlinedTextField(
         value = email,
         onValueChange = { onNewEmail(it) },
         leadingIcon = { Icon(
             imageVector = Icons.Default.Email,
             contentDescription = "email") },
         placeholder = {Text("Enter Your Email Here...") },
         shape = RoundedCornerShape(10),
         colors = TextFieldDefaults.outlinedTextFieldColors(
             focusedBorderColor = Color.Yellow,
             leadingIconColor = Color.White,
             backgroundColor = Color.Transparent)
     )
}
@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit)
{
   PasswordTextField(password = password, onPasswordChange = onPasswordChange, modifier = modifier)
}

@Composable
private fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit)
{
    var visibility by remember { mutableStateOf(false) }
    val passwordIcon = if(visibility) painterResource(R.drawable.ic_visibility_off)
                       else painterResource(R.drawable.ic_visibility_on)

    val visualTransformation = if(visibility) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        placeholder = { Text(text = "password") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "password leadingIcon") },
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    painter = passwordIcon,
                    contentDescription = "password trailing icon")
        }},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Yellow,
            leadingIconColor = Color.White,
            backgroundColor = Color.Transparent)
    )
}

