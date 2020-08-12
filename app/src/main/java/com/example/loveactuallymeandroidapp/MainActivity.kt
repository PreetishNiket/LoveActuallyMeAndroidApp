package com.example.loveactuallymeandroidapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.loveactuallymeandroidapp.ui.ProfileInfoActivity
import com.example.loveactuallymeandroidapp.ui.navUi.ChatFragment
import com.example.loveactuallymeandroidapp.ui.navUi.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment=HomeFragment()
    private val chatFragment=ChatFragment()
    private val mBottomNav=BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.home_menu ->{
                switchBetweenFragments(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.chat_menu->{
                switchBetweenFragments(chatFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile_menu->{
                val i=Intent(this, ProfileInfoActivity::class.java)
                startActivity(i)
                return@OnNavigationItemSelectedListener true
            }
            else->{
                switchBetweenFragments(homeFragment)
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_view.setOnNavigationItemSelectedListener(mBottomNav)
        switchBetweenFragments(homeFragment)
    }
    private fun switchBetweenFragments(fragment: Fragment) {
        val fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frag_container,fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.isAddToBackStackAllowed
        fragmentTransaction.commit()
    }

    override fun onResume() {
        switchBetweenFragments(homeFragment)
        super.onResume()
    }
}