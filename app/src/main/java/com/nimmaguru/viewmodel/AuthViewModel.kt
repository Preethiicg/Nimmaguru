package com.nimmaguru.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nimmaguru.data.repository.FirebaseRepository

class AuthViewModel : ViewModel() {
    private val repo = FirebaseRepository()
    val status = MutableLiveData<String>()

    fun login(email: String, password: String) = repo.login(email, password) { ok, err -> status.value = if (ok) "success" else (err ?: "failed") }
    fun register(email: String, password: String, role: String) = repo.register(email, password, role) { ok, err -> status.value = if (ok) "success" else (err ?: "failed") }
}
