package com.zuzob00l.smartapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zuzob00l.smartapp.R

@Composable
fun MessageText(
    text: Int,
    color: Color = Color.Black)
{
  Icon(
      modifier = Modifier
          .padding(end = 3.dp)
          .size(18.dp),
      painter = painterResource(R.drawable.ic_worning_icon),
      tint = color,
      contentDescription = null)

  Text(
      text = stringResource(id = text),
      fontSize = 18.sp,
      color = color)
}
@Composable
fun LogInMessageText()
{
    Text(
        modifier = Modifier.padding(bottom = 20.dp, top = 40.dp),
        text = stringResource(R.string.Zaloguj_się),
        color = Color.Black,
        fontSize = 25.sp)
}