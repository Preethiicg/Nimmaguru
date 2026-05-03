package com.nimmaguru.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nimmaguru.R
import com.nimmaguru.ui.main.MainActivity

class RoleSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_role_selection)
        findViewById<Button>(R.id.btnGuru).setOnClickListener { open("guru") }
        findViewById<Button>(R.id.btnStudent).setOnClickListener { open("student") }
    }
    private fun open(role: String) { startActivity(Intent(this, MainActivity::class.java).putExtra("role", role)) }
}
