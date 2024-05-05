package com.zuzob00l.smartapp.firebaseAuth.data

import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zuzob00l.smartapp.firebaseAuth.firebase_model.USER_COLLECTION
import com.zuzob00l.smartapp.firebaseAuth.firebase_model.User
import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore
) : AuthRepository {
    override fun loginUser(
        email: String,
        password: String
    ): Flow<Resource<AuthResult>>
    {
       return flow {
           emit(Resource.Loading())
           val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
           emit(Resource.Success(result))

       }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override fun registerUser(
        email: String,
        password: String,
        name: String,
        surname: String
    ): Flow<Resource<AuthResult>>
    {
        return flow {

            Log.d("Reg","0")
            //emit(Resource.Loading())
            Log.d("Reg","1")
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

            Log.d("Reg","2")
            val userId = firebaseAuth.currentUser?.uid

            val user = User(
                name = name,
                surname = surname,
                email = email)

            // create document with user
            val doc = firebaseFirestore.collection(USER_COLLECTION).document(userId.toString())
            // populate user document with data
            doc.set(user)
            emit(Resource.Loading())
            emit(Resource.Success(result))

        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }
}