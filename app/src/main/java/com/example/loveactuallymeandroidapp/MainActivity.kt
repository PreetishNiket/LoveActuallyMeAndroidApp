package com.example.loveactuallymeandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.loveactuallymeandroidapp.ui.other.ProfileInfoActivity
import com.example.loveactuallymeandroidapp.ui.navUi.ChatFragment
import com.example.loveactuallymeandroidapp.ui.navUi.HomeFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
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
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private fun updateStatus(status:String){
        val ref=FirebaseDatabase.getInstance().reference.child("Users")
            .child(auth.currentUser!!.uid)
        val hashMap=HashMap<String,Any>()
        hashMap["status"]=status
        ref.updateChildren(hashMap)
    }
    override fun onResume() {
        switchBetweenFragments(homeFragment)
        updateStatus("online")
        super.onResume()
    }

    override fun onPause() {
        updateStatus("offline")
        super.onPause()
    }
}