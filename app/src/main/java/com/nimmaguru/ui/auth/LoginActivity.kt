package com.nimmaguru.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nimmaguru.R
import com.nimmaguru.ui.main.MainActivity
import com.nimmaguru.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity() {
    private val vm: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_login)
        val email = findViewById<EditText>(R.id.etEmail)
        val pass = findViewById<EditText>(R.id.etPassword)
        findViewById<Button>(R.id.btnLogin).setOnClickListener { vm.login(email.text.toString(), pass.text.toString()) }
        findViewById<TextView>(R.id.tvGoRegister).setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
        vm.status.observe(this) { if (it == "success") startActivity(Intent(this, RoleSelectionActivity::class.java)) else Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }
}
