package com.nimmaguru.ui.main.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.nimmaguru.R
import com.nimmaguru.data.model.Guru
import com.nimmaguru.ui.main.adapters.GuruAdapter
import com.nimmaguru.viewmodel.MainViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {
    private val vm: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val chipGroup = view.findViewById<ChipGroup>(R.id.chipGroupSkills)
        listOf("Math", "Science", "Carpentry").forEach { t -> chipGroup.addView(Chip(requireContext()).apply { text = t; isCheckable = true }) }
        val location = view.findViewById<EditText>(R.id.etLocationFilter)
        val rv = view.findViewById<RecyclerView>(R.id.rvGurus)
        val adapter = GuruAdapter(emptyList()); rv.layoutManager = LinearLayoutManager(requireContext()); rv.adapter = adapter
        vm.loadGurus(); vm.gurus.observe(viewLifecycleOwner) { dbList ->
            val all = if (dbList.isEmpty()) sampleGurus() else dbList
            val skill = chipGroup.checkedChipId.takeIf { it != View.NO_ID }?.let { view.findViewById<Chip>(it).text.toString() }
            val filtered = all.filter { g -> (skill == null || g.skills.contains(skill)) && g.location.contains(location.text.toString(), true) }
            adapter.update(filtered)
        }
        chipGroup.setOnCheckedStateChangeListener { _, _ -> vm.gurus.value?.let { vm.gurus.postValue(it) } }
    }

    private fun sampleGurus(): List<Guru> = listOf(
        Guru(id = "demo1", name = "Shankar Rao", skills = listOf("Math", "Science"), availability = "Sat 4:00 PM - 6:00 PM", location = "Mandya", bio = "Retired high school teacher"),
        Guru(id = "demo2", name = "Meera Tai", skills = listOf("Carpentry"), availability = "Sun 9:00 AM - 11:00 AM", location = "Mysuru", bio = "Skilled craft mentor")
    )
}
