package com.zuzob00l.smartapp.firebaseAuth.data

import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import kotlinx.coroutines.flow.Flow

interface StorageRepository
{
    fun getImageURIFromFirestore(): Flow<Resource<String>>

}