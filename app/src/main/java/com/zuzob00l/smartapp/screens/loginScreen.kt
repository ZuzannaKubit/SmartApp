package com.zuzob00l.smartapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.modifiers.backgroundImageModifier

@Composable
fun LoginScreen()
{

}

@Composable
fun LoginScreenContent(
    onLoginClicked: (String, String) -> Unit,
) {
    val loginBackgroundImage = ImageBitmap.imageResource(R.drawable.ic_background)

    Image(
        modifier = Modifier.backgroundImageModifier(),
        bitmap = loginBackgroundImage,
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        contentDescription = "login background")

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(
            text = stringResource(R.string.nie_masz_konta),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal)
        Text(
            modifier = Modifier
                .padding(start = 3.dp)
                .clickable { },
            text = stringResource(R.string.zarejestruj_sie),
            fontSize = 18.sp,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SubmitButton(
    text: String,
    onSubmitButtonClicked: () -> Unit)
{
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.White))
    {
        Text(
            fontSize = 20.sp,
            text = text)
    }
}
