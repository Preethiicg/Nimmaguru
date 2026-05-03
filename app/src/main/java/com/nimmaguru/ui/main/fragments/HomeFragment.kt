package com.nimmaguru.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimmaguru.R
import com.nimmaguru.data.model.Session
import com.nimmaguru.ui.main.adapters.SimpleTextAdapter
import com.nimmaguru.viewmodel.MainViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val vm: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rvSessions)
        val adapter = SimpleTextAdapter(emptyList()); rv.layoutManager = LinearLayoutManager(requireContext()); rv.adapter = adapter
        vm.loadSessions()
        vm.sessions.observe(viewLifecycleOwner) { list ->
            val displayList = if (list.isEmpty()) sampleSessions() else list
            adapter.update(displayList.map { s -> "👩‍🏫 ${s.guruName}\n📘 ${s.subject}\n📅 ${s.date}\n📍 ${s.location}" })
        }
    }

    private fun sampleSessions(): List<Session> = listOf(
        Session(guruName = "Rao Sir", subject = "Math", date = "Every Saturday, 10:00 AM", location = "Samudaya Bhavana"),
        Session(guruName = "Lakshmi Ma'am", subject = "Science", date = "Every Sunday, 11:30 AM", location = "Community Hall")
    )
}
