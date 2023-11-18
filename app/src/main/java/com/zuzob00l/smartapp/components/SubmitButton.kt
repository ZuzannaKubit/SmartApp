package com.zuzob00l.smartapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubmitButton(
    text: String,
    onDone: () -> Unit,
    color: Color = Color.Yellow,
    textColor: Color = Color.Black)
{
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = { onDone() },
        colors = ButtonDefaults.buttonColors(color))
    {
        Text(
            fontSize = 20.sp,
            text = text,
            color = textColor)
    }
}