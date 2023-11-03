package com.zuzob00l.smartapp.model

import androidx.annotation.DrawableRes
import com.zuzob00l.smartapp.R
enum class Language(
    @DrawableRes val icon: Int)
{
    Polski(R.drawable.ic_newpolishflag),
    English(R.drawable.ic_english_flag)
}
