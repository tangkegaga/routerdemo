package com.example.routerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


var bottomNavigation: BottomNavigationView? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_search -> {
                    true
                }
                R.id.menu_auth -> {
                    true
                }
                R.id.menu_bolt -> {

                    true
                }
                else -> false
            }
        }
    }
}