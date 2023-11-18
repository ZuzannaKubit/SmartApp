package com.zuzob00l.smartapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.components.HomeButton

@Composable
fun HomeScreen(navController: NavController)
{
   Column(
      modifier = Modifier
         .padding(16.dp)
         .fillMaxSize())
   {
      //ProfileOptions()
      // AdvertiseBanner()
      HomeScreenButtons()
   }
}

@Composable
fun HomeScreenButtons()
{
   Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally)
   {
      HomeButton(
         text = R.string._moje_konto,
         icon = R.drawable.ic_account_icon,
         contentDescription = R.string.account_icon,
         onClick = {})

      HomeButton(
         text = R.string.karnety,
         icon = R.drawable.ic_pass_icon,
         contentDescription = R.string.pass_icon)

      HomeButton(
         text = R.string.platnosci,
         icon = R.drawable.ic_wallet_icon,
         contentDescription = R.string.peyment_icon)

      HomeButton(
         text = R.string.aktywnosci,
         icon = R.drawable.ic_calendar_icon,
         contentDescription = R.string.pass_icon)

   }
}

