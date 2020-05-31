package com.example.routerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.basemodule.context
import com.example.routerservicemodule.getAppConfigReceiverService
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
                    context.getAppConfigReceiverService()?.getSearchEntryFragment()?.let {
                        openFragment(it)
                    }
                    true
                }
                R.id.menu_auth -> {
                    context.getAppConfigReceiverService()?.getAuthEntryFragment()?.let {
                        openFragment(it)
                    }
                    true
                }
                R.id.menu_bolt -> {
                    context.getAppConfigReceiverService()?.getBoltEntryFragment()?.let {
                        openFragment(it)
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}