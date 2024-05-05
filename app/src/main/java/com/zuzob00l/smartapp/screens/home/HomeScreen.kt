package com.zuzob00l.smartapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.components.HomeButton
import com.zuzob00l.smartapp.components.MenuItem
import com.zuzob00l.smartapp.components.menuItem

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
      Menu()
   }
}
@Composable
fun Menu()
{
   LazyRow(
      modifier = Modifier
         .padding(5.dp)
         .fillMaxWidth())
   {

      items(menuItem) { item ->
         Surface(
            modifier = Modifier
               .clickable { item.onItemClick }
               .size(150.dp, 150.dp)
               .padding(end = 16.dp),
            elevation = 6.dp,
            color = item.color,
            shape = RoundedCornerShape(20))
         {
            Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
            ) {
               Icon(
                  modifier = Modifier
                     .size(50.dp)
                     .padding(bottom = 16.dp),
                  painter = painterResource(item.icon),
                  tint = item.textAndIconColor,
                  contentDescription = null)

               Text(
                  text = stringResource(item.text),
                  color = item.textAndIconColor,
                  fontSize = 20.sp,
                  fontWeight = FontWeight.Bold)
            }
         }
      }
   }
}
@Preview(showBackground = true)
@Composable
fun MenuPreview() {
   Menu()
}
