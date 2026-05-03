package com.nimmaguru.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nimmaguru.R
import com.nimmaguru.viewmodel.AuthViewModel

class RegisterActivity : AppCompatActivity() {
    private val vm: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_register)
        val email = findViewById<EditText>(R.id.etEmail)
        val pass = findViewById<EditText>(R.id.etPassword)
        val role = findViewById<Spinner>(R.id.spRole)
        role.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("Guru", "Student"))
        findViewById<Button>(R.id.btnRegister).setOnClickListener { vm.register(email.text.toString(), pass.text.toString(), role.selectedItem.toString().lowercase()) }
        vm.status.observe(this) { if (it == "success") startActivity(Intent(this, LoginActivity::class.java)) else Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }
}
