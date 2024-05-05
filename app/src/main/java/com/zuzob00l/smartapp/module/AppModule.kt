package com.zuzob00l.smartapp.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.zuzob00l.smartapp.firebaseAuth.data.AuthRepository
import com.zuzob00l.smartapp.firebaseAuth.data.AuthRepositoryImpl
import com.zuzob00l.smartapp.firebaseAuth.data.StorageRepository
import com.zuzob00l.smartapp.firebaseAuth.data.StorageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth, firebaseFirestore: FirebaseFirestore) : AuthRepository {

        return AuthRepositoryImpl(firebaseAuth, firebaseFirestore)
    }
    @Provides
    @Singleton
    fun providesStorage() = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun providesFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryStorageImpl(firebaseFirestore: FirebaseFirestore, storage: FirebaseStorage) : StorageRepository {

        return StorageRepositoryImpl(storage, firebaseFirestore)
    }

}