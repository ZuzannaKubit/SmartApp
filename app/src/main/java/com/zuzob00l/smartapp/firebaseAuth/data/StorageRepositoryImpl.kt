package com.zuzob00l.smartapp.firebaseAuth.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.zuzob00l.smartapp.firebaseAuth.firebase_model.IMAGES_COLLECTION
import com.zuzob00l.smartapp.firebaseAuth.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val storage: FirebaseStorage,
    private val db: FirebaseFirestore
): StorageRepository
{
    override fun getImageURIFromFirestore(): Flow<Resource<String>>
    {
       return flow {
           Log.d("Image","cokolwiek")
           val imageUri = db.collection(IMAGES_COLLECTION).get().await()
           //val gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg")
           Log.d("Image","${ imageUri.toString()}")
           emit(Resource.Loading())
           emit(Resource.Success(imageUri.toString()))
       }
           .catch {
               emit(Resource.Error(it.message.toString()))
           }

    }
}