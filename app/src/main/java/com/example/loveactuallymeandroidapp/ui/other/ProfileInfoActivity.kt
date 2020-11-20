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
                Picasso.get().load(image).into(imageView1)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@ProfileInfoActivity, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })
        val photoRef:DatabaseReference=rootRef.child("MoreImages").child(id)
            photoRef.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val image1 =snapshot.child("image1").getValue(String::class.java)
                    val image2 =snapshot.child("image2").getValue(String::class.java)
                    val image3 =snapshot.child("image3").getValue(String::class.java)
                    val image4 =snapshot.child("image4").getValue(String::class.java)
                    val image5 =snapshot.child("image5").getValue(String::class.java)
                    Picasso.get().load(image1).into(imageView2)
                    Picasso.get().load(image2).into(imageView3)
                    Picasso.get().load(image3).into(imageView4)
                    Picasso.get().load(image4).into(imageView5)
                    Picasso.get().load(image5).into(imageView6)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        back1.setOnClickListener {
            finish()
        }
    }
}