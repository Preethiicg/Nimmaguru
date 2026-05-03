package com.nimmaguru.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimmaguru.R
import com.nimmaguru.ui.main.adapters.SimpleTextAdapter
import com.nimmaguru.viewmodel.MainViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val vm: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rvSessions)
        val adapter = SimpleTextAdapter(emptyList()); rv.layoutManager = LinearLayoutManager(requireContext()); rv.adapter = adapter
        vm.loadSessions(); vm.sessions.observe(viewLifecycleOwner) { adapter.update(it.map { s -> "${s.guruName} - ${s.subject} - ${s.date} - ${s.location}" }) }
    }
}
