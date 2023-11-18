package com.zuzob00l.smartapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import com.zuzob00l.smartapp.R

@Composable
fun HomeButton(
    text: Int,
    @DrawableRes icon: Int,
    contentDescription: Int,
    onClick: () -> Unit = {})
{
   OutlinedButton(
       modifier = Modifier
           .padding(4.dp)
           .height(48.dp)
           .fillMaxWidth(),
       onClick = onClick,
      // border = BorderStroke(1.dp, color = Color.Gray),
       elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
       shape = RoundedCornerShape(10))
   {
     Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Start)
     {
       Icon(
           modifier = Modifier
               .padding(horizontal = 5.dp)
               .size(25.dp),
           painter = painterResource(icon),
           contentDescription = stringResource(contentDescription),
           tint = Color.DarkGray)

         Text(
             text = stringResource(text),
             fontSize = 20.sp,
             fontWeight = FontWeight.SemiBold,
             color = Color.DarkGray)
         Spacer(modifier = Modifier.weight(1f))
     }
   }
}
@Preview(showBackground = true)
@Composable
fun HomeButtonsPreview()
{
    Column {

        HomeButton(
            text = R.string._moje_konto,
            icon = R.drawable.ic_account_icon,
            contentDescription = R.string.account_icon
        )
        HomeButton(
            text = R.string.karnety,
            icon = R.drawable.ic_pass_icon,
            contentDescription = R.string.pass_icon
        )
    }
     }


