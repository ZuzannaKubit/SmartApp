package com.zuzob00l.smartapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.model.Language

@Composable
fun LanguageDropDown(
    language: Language,
    onLanguageSelected:(Language) -> Unit = {})
{
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .size(height = 40.dp, width = 120.dp)
            .padding(vertical = 4.dp, horizontal = 6.dp)
            .clickable { expanded = true },
        shape = RoundedCornerShape(40),
        color = Color.White,
        elevation = 4.dp)
    {
        Row(
            //modifier = Modifier.clickable { expanded = true },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
          Image(
              modifier = Modifier.size(25.dp),
              painter = painterResource(language.icon),
              contentDescription = "language_icon")
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = language.name,
                fontSize = 18.sp,
                color = Color.Black)

            MaterialTheme(
                shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(16.dp))) {
                DropdownMenu(
                    modifier = Modifier.wrapContentSize(),
                    expanded = expanded,
                    onDismissRequest = { expanded = false })
                {
                    DropdownMenuItem(onClick = {
                        expanded = false
                        onLanguageSelected(Language.English)
                    })
                    {
                        LanguageItem(language = Language.English)
                    }

                    DropdownMenuItem(onClick = {
                        expanded = false
                        onLanguageSelected(Language.Polski)
                    }) {
                        LanguageItem(Language.Polski)
                    }
                }
            }
        }
    }
}
@Composable
fun LanguageItem(language: Language) {

    Surface(
        modifier = Modifier
        .size(height = 40.dp, width = 120.dp)
        .padding(vertical = 4.dp, horizontal = 6.dp),
        shape = RoundedCornerShape(40),
        color = Color.White
    )
    {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(language.icon),
                contentDescription = "language_icon")

            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = language.name,
                fontSize = 18.sp,
                color = Color.Black)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LanguageDropDownPreview()
{
    LanguageDropDown(language = Language.Polski)
}

