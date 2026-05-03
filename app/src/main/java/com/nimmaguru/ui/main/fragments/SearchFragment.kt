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
        vm.loadGurus(); vm.gurus.observe(viewLifecycleOwner) { all ->
            val skill = chipGroup.checkedChipId.takeIf { it != View.NO_ID }?.let { view.findViewById<Chip>(it).text.toString() }
            val filtered = all.filter { g -> (skill == null || g.skills.contains(skill)) && g.location.contains(location.text.toString(), true) }
            adapter.update(filtered)
        }
        chipGroup.setOnCheckedStateChangeListener { _, _ -> vm.gurus.value?.let { vm.gurus.postValue(it) } }
    }
}
