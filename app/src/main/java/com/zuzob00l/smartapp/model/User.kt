package com.zuzob00l.smartapp.model

data class User(
    val id: String?,
    val userId: String,
    val isMembership: Boolean,
    val userGym: String,
    val membership: Membership
)
