package com.nimmaguru.ui.main.fragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.firebase.auth.FirebaseAuth
import com.nimmaguru.R
import com.nimmaguru.data.model.Guru
import com.nimmaguru.viewmodel.MainViewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val vm: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val guru = Guru(
                id = FirebaseAuth.getInstance().currentUser?.uid ?: "",
                name = view.findViewById<EditText>(R.id.etName).text.toString(),
                skills = view.findViewById<EditText>(R.id.etSkills).text.toString().split(",").map { it.trim() },
                availability = view.findViewById<EditText>(R.id.etAvailability).text.toString(),
                location = view.findViewById<EditText>(R.id.etLocation).text.toString(),
                bio = view.findViewById<EditText>(R.id.etBio).text.toString()
            )
            vm.saveGuru(guru) { Toast.makeText(requireContext(), if (it) "Saved" else "Failed", Toast.LENGTH_SHORT).show() }
        }
    }
}
