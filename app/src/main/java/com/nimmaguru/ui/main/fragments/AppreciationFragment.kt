package com.nimmaguru.ui.main.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimmaguru.R
import com.nimmaguru.data.model.Appreciation
import com.nimmaguru.ui.main.adapters.SimpleTextAdapter
import com.nimmaguru.viewmodel.MainViewModel

class AppreciationFragment : Fragment(R.layout.fragment_appreciation) {
    private val vm: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = SimpleTextAdapter(emptyList())
        view.findViewById<RecyclerView>(R.id.rvThanks).apply { layoutManager = LinearLayoutManager(requireContext()); this.adapter = adapter }
        vm.loadAppreciations(); vm.appreciations.observe(viewLifecycleOwner) { adapter.update(it.map { a -> "${a.studentName}: ${a.message}" }) }
        view.findViewById<Button>(R.id.btnPost).setOnClickListener {
            vm.postThanks(Appreciation(studentName = view.findViewById<EditText>(R.id.etStudentName).text.toString(), message = view.findViewById<EditText>(R.id.etMessage).text.toString())) {}
        }
    }
}
