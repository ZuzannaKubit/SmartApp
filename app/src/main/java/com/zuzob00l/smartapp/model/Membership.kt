package com.zuzob00l.smartapp.model

sealed class Membership {

    class OPEN() : Membership()
    {
        val name = "Open"
        val price = 99.99
        val duration = 28
    }
    fun getMembershipDuration() {

    }
}


