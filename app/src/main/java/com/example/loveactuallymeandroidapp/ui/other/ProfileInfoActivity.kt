package com.example.loveactuallymeandroidapp.ui.other

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_profile_info2.*

class ProfileInfoActivity : AppCompatActivity() {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        supportActionBar?.hide()
        set_pro.setOnClickListener {
            startActivity(Intent(this,
                ProfileInfo2Activity::class.java))
        }
        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val id=auth.currentUser?.uid
        // Database reference pointing to demo node
        val demoRef: DatabaseReference = rootRef.child("Users").child(id!!)

        demoRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val name = dataSnapshot.child("Name").getValue(String::class.java)
                val image =dataSnapshot.child("userImage").getValue(String::class.java)
                tvperson.text=name
                Picasso.get().load(image).into(image_profile)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@ProfileInfoActivity, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })
        back1.setOnClickListener {
            finish()
        }
    }
}