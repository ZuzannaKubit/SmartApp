package com.zuzob00l.smartapp.screens.StartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.components.LanguageDropDown
import com.zuzob00l.smartapp.model.Language
import com.zuzob00l.smartapp.modifiers.backgroundImageModifier
import com.zuzob00l.smartapp.modifiers.startButtonModifier
import com.zuzob00l.smartapp.navigation.SmartAppScreens

@Composable
fun StartScreen(
    navController: NavController)
{
    val loginBackgroundImage = ImageBitmap.imageResource(R.drawable.ic_background)

    Image(
        modifier = Modifier.backgroundImageModifier(),
        bitmap = loginBackgroundImage,
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        contentDescription = "login background")

        StartScreenContent(
            onLoginClicked = { navController.navigate(SmartAppScreens.LoginScreen.name) },
            onSignInClicked = { navController.navigate(SmartAppScreens.LoginScreen.name) })
}
@Composable
fun StartScreenContent(
    onLoginClicked: () -> Unit,
    onSignInClicked: () -> Unit)
{

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, end = 8.dp)
        .wrapContentHeight())
    {
        Spacer(modifier = Modifier.weight(1f))
        Box()
        {
            LanguageDropDown(language = Language.Polski)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 40.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        LogoCard()
        Spacer(modifier = Modifier.height(50.dp))
         StartButton(
             text = stringResource(R.string.Zaloguj_się),
             textColor = Color.Black,
             onButtonClicked = { onLoginClicked() },
             modifier = Modifier.startButtonModifier(),
             color = ButtonDefaults.buttonColors(Color.Yellow))

        StartButton(
            text = stringResource(R.string.zarejestruj_sie),
            textColor = Color.White,
            onButtonClicked = { onSignInClicked() },
            modifier = Modifier.startButtonModifier(),
            color = ButtonDefaults.buttonColors(Color.Black)
        )
    }
}
@Composable
fun StartButton(
    text: String,
    textColor: Color,
    onButtonClicked: () -> Unit,
    modifier: Modifier,
    color: ButtonColors)
{
    Button(
        modifier = modifier,
        onClick = onButtonClicked,
        colors = color,
        shape = RoundedCornerShape(10)
    )
    {
        Text(
            text = text ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = textColor)
    }
}
@Composable
fun LogoCard()
{
    val logoImage = painterResource(R.drawable.ic_logo_with_background)

          Image(
              modifier = Modifier.size(150.dp),
              alignment = Alignment.Center,
              painter = logoImage,
              contentDescription = "logo")
      }
/*@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen()
}*/