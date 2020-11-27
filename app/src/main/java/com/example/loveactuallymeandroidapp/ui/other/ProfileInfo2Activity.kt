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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_profile_info2.*

class ProfileInfo2Activity : AppCompatActivity() {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    private lateinit var list: ArrayList<ProfileInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info2)
        supportActionBar?.hide()
        list = ArrayList()

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val id = auth.currentUser?.uid
        // Database reference pointing to demo node
        val demoRef: DatabaseReference = rootRef.child("Users").child(id!!)
        demoRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val name = dataSnapshot.child("Name").getValue(String::class.java).toString()
                val ability = dataSnapshot.child("Ability").getValue(String::class.java).toString()
                val dob = dataSnapshot.child("Date_of_Birth").getValue(String::class.java).toString()
                val education = dataSnapshot.child("Education").getValue(String::class.java).toString()
                val gender = dataSnapshot.child("Gender").getValue(String::class.java).toString()
                val mobilenumber = dataSnapshot.child("Mobile_Number").getValue(String::class.java).toString()
                val religion = dataSnapshot.child("Religious_Belief").getValue(String::class.java).toString()
                val drinking = dataSnapshot.child("Drinking").getValue(String::class.java).toString()
                val smoking = dataSnapshot.child("Smoking").getValue(String::class.java).toString()
                val connect = dataSnapshot.child("Connect").getValue(String::class.java).toString()
                val info=dataSnapshot.child("About").getValue(String::class.java).toString()
                val image =dataSnapshot.child("userImage").getValue(String::class.java).toString()
                list = arrayListOf(
                    ProfileInfo("Info", info),
                    ProfileInfo("Name", name),
                    ProfileInfo("Ability", ability),
                    ProfileInfo("Date of Birth", dob),
                    ProfileInfo("Education", education),
                    ProfileInfo("Gender", gender),
                    ProfileInfo("Mobile Number", mobilenumber),
                    ProfileInfo("Religious Belief", religion),
                    ProfileInfo("Drinking", drinking),
                    ProfileInfo("Smoking", smoking),
                    ProfileInfo("Connect", connect)
                )
                rv_profile_info.layoutManager = LinearLayoutManager(baseContext)
                rv_profile_info.adapter = ProfileInfoAdapter(list)
                tv.text = name
                Picasso.get().load(image).into(profile_photo1)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@ProfileInfo2Activity, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })

        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        with(tv){


        }
    }
}