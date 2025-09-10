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
        openFragment(context.getAppConfigReceiverService()?.getSearchEntryFragment())
        bottomNavigation = findViewById(R.id.bottom_navigation_a);
        
        bottomNavigation?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_search -> {
                    openFragment(context.getAppConfigReceiverService()?.getSearchEntryFragment())
                    true
                }
                R.id.menu_auth -> {
                    openFragment(context.getAppConfigReceiverService()?.getAuthEntryFragment())
                    true
                }
                R.id.menu_bolt -> {
                    openFragment(context.getAppConfigReceiverService()?.getBoltEntryFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment?) {
        fragment?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
