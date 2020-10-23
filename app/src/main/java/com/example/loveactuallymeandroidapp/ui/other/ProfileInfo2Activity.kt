package com.example.loveactuallymeandroidapp.ui.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.ProfileInfoAdapter
import com.example.loveactuallymeandroidapp.dataClass.ProfileInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile_info2.*

class ProfileInfo2Activity : AppCompatActivity() {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    private val list= arrayListOf(ProfileInfo("Name"),
                                                      ProfileInfo("Gender"),
                                                      ProfileInfo("Age"),
        ProfileInfo("Height"),
        ProfileInfo("Drinking Habits"),
        ProfileInfo("Connections"),
        ProfileInfo("Education"),
        ProfileInfo("Occupation"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info2)
        supportActionBar?.hide()
        rv_profile_info.layoutManager=LinearLayoutManager(this)
        rv_profile_info.adapter=ProfileInfoAdapter(list)


        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val id=auth.currentUser?.uid
        // Database reference pointing to demo node
        val demoRef: DatabaseReference = rootRef.child("Users").child(id!!)
        demoRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var name = dataSnapshot.child("Name").getValue(String::class.java)
                var ability = dataSnapshot.child("Ability").getValue(String::class.java)
                var dob = dataSnapshot.child("Date_of_Birth").getValue(String::class.java)
                var education = dataSnapshot.child("Education").getValue(String::class.java)
                var gender = dataSnapshot.child("Gender").getValue(String::class.java)
                var mobilenumber = dataSnapshot.child("Mobile_Number").getValue(String::class.java)
                var religion = dataSnapshot.child("Religious_Belief").getValue(String::class.java)
                var drinking = dataSnapshot.child("Drinking").getValue(String::class.java)
                var smoking = dataSnapshot.child("Smoking").getValue(String::class.java)
                var connect = dataSnapshot.child("Connect").getValue(String::class.java)
//                connectionsofuser.text=connect
//                smokinghabitsofuser.text=smoking
//                drinkinghabitsofuser.text=drinking
//                nameofuser.text=name
//                orientationofuser.text=ability
//                mobileofuser.text=mobilenumber
//                ageofuser.text=dob
//                educationofuser.text=education
//                genderofuser.text=gender
//                religionofuser.text=religion
//                tv.text=name
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@ProfileInfo2Activity, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })
        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}