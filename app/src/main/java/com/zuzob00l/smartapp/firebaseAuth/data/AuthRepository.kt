package com.zuzob00l.smartapp.firebaseAuth.data

import com.google.firebase.auth.AuthResult
import com.google.rpc.context.AttributeContext
import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository
{
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(
        email: String,
        password: String,
        name: String,
        surname: String): Flow<Resource<AuthResult>>
}