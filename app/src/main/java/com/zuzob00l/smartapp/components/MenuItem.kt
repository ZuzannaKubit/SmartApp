package com.zuzob00l.smartapp.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.ui.theme.YellowLight

data class MenuItem(
    val text: Int,
    val icon: Int,
    val textAndIconColor: Color,
    val color: Color,
    val onItemClick: () -> Unit)

val menuItem = listOf<MenuItem>(
    MenuItem(
        R.string.moje_konto,
        R.drawable.ic_account_icon,
        Color.Black,
        YellowLight,
        onItemClick = {  }
    ),
    MenuItem(
        R.string.karnety,
        R.drawable.ic_pass_icon,
        Color.Gray,
        Color.White,
        onItemClick = {  }
    ),
    MenuItem(
        R.string.platnosci,
        R.drawable.ic_wallet_icon,
        Color.Black,
        YellowLight,
        onItemClick = {  }
    ),
    MenuItem(
        R.string.aktywnosci,
        R.drawable.ic_calendar_icon,
        Color.Gray,
        Color.White,
        onItemClick = {  }
    )
)

