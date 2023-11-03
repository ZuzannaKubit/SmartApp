package com.zuzob00l.smartapp.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.textFieldsModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(vertical = 5.dp)
}

fun Modifier.backgroundImageModifier(): Modifier {
    return this
        .fillMaxSize()
        .background(color = Color.Black)
}

fun Modifier.startButtonModifier() : Modifier {
    return this
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .height(48.dp)
}
fun Modifier.dropDownModifier() : Modifier {
    return this
        .padding(4.dp)
        .wrapContentSize()
}