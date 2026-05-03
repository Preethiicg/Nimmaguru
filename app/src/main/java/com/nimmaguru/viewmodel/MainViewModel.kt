package com.nimmaguru.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nimmaguru.data.model.Appreciation
import com.nimmaguru.data.model.Guru
import com.nimmaguru.data.model.Session
import com.nimmaguru.data.repository.FirebaseRepository

class MainViewModel : ViewModel() {
    private val repo = FirebaseRepository()
    val gurus = MutableLiveData<List<Guru>>()
    val sessions = MutableLiveData<List<Session>>()
    val appreciations = MutableLiveData<List<Appreciation>>()

    fun loadGurus() = repo.getGurus(gurus)
    fun loadSessions() = repo.getSessions(sessions)
    fun loadAppreciations() = repo.getAppreciations(appreciations)
    fun saveGuru(guru: Guru, cb: (Boolean) -> Unit) = repo.saveGuruProfile(guru, cb)
    fun postThanks(a: Appreciation, cb: (Boolean) -> Unit) = repo.postAppreciation(a, cb)
}
