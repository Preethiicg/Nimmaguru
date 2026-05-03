package com.nimmaguru.data.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nimmaguru.data.model.Appreciation
import com.nimmaguru.data.model.Guru
import com.nimmaguru.data.model.Session
import com.nimmaguru.data.model.User

class FirebaseRepository {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun login(email: String, password: String, cb: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { cb(it.isSuccessful, it.exception?.message) }
    }

    fun register(email: String, password: String, role: String, cb: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (!result.isSuccessful) cb(false, result.exception?.message)
            else {
                val uid = auth.currentUser?.uid ?: return@addOnCompleteListener
                db.collection("users").document(uid).set(User(uid, email, role)).addOnSuccessListener { cb(true, null) }
            }
        }
    }

    fun saveGuruProfile(guru: Guru, cb: (Boolean) -> Unit) = db.collection("gurus").document(guru.id).set(guru).addOnCompleteListener { cb(it.isSuccessful) }

    fun getGurus(liveData: MutableLiveData<List<Guru>>) = db.collection("gurus").addSnapshotListener { value, _ ->
        liveData.value = value?.toObjects(Guru::class.java) ?: emptyList()
    }

    fun getSessions(liveData: MutableLiveData<List<Session>>) = db.collection("sessions").addSnapshotListener { v, _ ->
        liveData.value = v?.toObjects(Session::class.java) ?: emptyList()
    }

    fun postAppreciation(item: Appreciation, cb: (Boolean) -> Unit) = db.collection("appreciations").add(item).addOnCompleteListener { cb(it.isSuccessful) }

    fun getAppreciations(liveData: MutableLiveData<List<Appreciation>>) = db.collection("appreciations").addSnapshotListener { v, _ ->
        liveData.value = v?.toObjects(Appreciation::class.java) ?: emptyList()
    }
}
