package com.nimmaguru.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nimmaguru.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main)
        val navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottomNav).setupWithNavController(navHost.navController)
    }
}
