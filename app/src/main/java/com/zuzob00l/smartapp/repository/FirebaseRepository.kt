package com.zuzob00l.smartapp.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.zuzob00l.smartapp.firebaseAuth.firebase_model.User
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.tasks.await

class FirebaseRepository {
    private var storage = FirebaseStorage.getInstance()
    private val fireStore = FirebaseStorage.getInstance()
    private val cloud = FirebaseFirestore.getInstance()

    suspend fun getDataFromFirestone(): User {

        val uid = Firebase.auth.currentUser
        var user = User()

        try {
            cloud.collection("user").get().await().map {
                val result = it.toObject(User::class.java)
                user = result
            }
        }
        catch (e: FirebaseFirestoreException) {
            Log.d("firebase error", "getDataFromFireStore: $e")
        }

        return user
    }

}