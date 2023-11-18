package com.zuzob00l.smartapp.firebaseAuth.presentation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zuzob00l.smartapp.firebaseAuth.firebase_model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserData_ViewModel : ViewModel()
{

    val uid = Firebase.auth.currentUser?.uid

    fun saveUserData(
        userData: User,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val cloud = Firebase.firestore.collection("user")
            .document(userData.uid!!)

        try{
            cloud.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Success, saved data", Toast.LENGTH_SHORT).show()
                }
        } catch (e:Exception)
        {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
    }

}
