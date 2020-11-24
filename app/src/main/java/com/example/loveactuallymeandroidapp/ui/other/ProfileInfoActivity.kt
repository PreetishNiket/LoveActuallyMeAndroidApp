package com.example.loveactuallymeandroidapp.ui.other

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.profile.MoreDetailsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_more_details.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_profile_info.back1
import kotlinx.android.synthetic.main.activity_profile_info.imageView1
import kotlinx.android.synthetic.main.activity_profile_info.imageView2
import kotlinx.android.synthetic.main.activity_profile_info.imageView3
import kotlinx.android.synthetic.main.activity_profile_info.imageView4
import kotlinx.android.synthetic.main.activity_profile_info.imageView5
import kotlinx.android.synthetic.main.activity_profile_info.imageView6
import kotlinx.android.synthetic.main.activity_profile_info2.*

class ProfileInfoActivity : AppCompatActivity() , View.OnClickListener{
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private lateinit var id: String
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

                override fun onCancelled(error: DatabaseError) {}

            })
        back1.setOnClickListener {
            finish()
        }

        imageView2.setOnClickListener(this)
        imageView3.setOnClickListener(this)
        imageView4.setOnClickListener(this)
        imageView5.setOnClickListener(this)
        imageView6.setOnClickListener(this)
    }
    private var int = 0
    override fun onClick(v: View) {
        if (v.id == R.id.imageView2) {
            galleryPick()
            int = 1

        }
        if (v.id == R.id.imageView3) {
            galleryPick()
            int = 2

        }
        if (v.id == R.id.imageView4) {
            galleryPick()
            int = 3
        }
        if (v.id == R.id.imageView5) {
            galleryPick()
            int = 4

        }
        if (v.id == R.id.imageView6) {
            galleryPick()
            int = 5

        }
    }
    companion object {
        const val GALLERY_PICKER = 1;
    }
    private fun galleryPick() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Pick An Image"), GALLERY_PICKER)
    }
    private val dbRef by lazy {
        FirebaseDatabase.getInstance().reference
    }
    private val photosRef by lazy {
        FirebaseStorage.getInstance().reference.child("MoreImages")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        id = auth.currentUser!!.uid
        if (requestCode == MoreDetailsActivity.GALLERY_PICKER && resultCode == RESULT_OK && data != null) {
            val imageData = data.data!!
            when (int) {
                1 -> {
                    imageView2.setImageURI(imageData)
                    val fileRef = photosRef.child(id + "img1" + ".jpg")
                    val uploadTask = fileRef.putFile(imageData)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        fileRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUrl = task.result.toString()

                            val userPhotos = HashMap<String,Any>()
                            userPhotos["image1"] = downloadUrl

                            dbRef.child("MoreImages").child(id)
                                .updateChildren(userPhotos)
                        }
                    }
                }
                2 -> {
                    imageView3.setImageURI(imageData)
                    val fileRef = photosRef.child(id + "img2" + ".jpg")
                    val uploadTask = fileRef.putFile(imageData)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        fileRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUrl = task.result.toString()

                            val userPhotos = HashMap<String,Any>()
                            userPhotos["image2"] = downloadUrl

                            dbRef.child("MoreImages").child(id)
                                .updateChildren(userPhotos)
                        }
                    }
                }
                3 -> {
                    imageView4.setImageURI(imageData)
                    val fileRef = photosRef.child(id + "img3" + ".jpg")
                    val uploadTask = fileRef.putFile(imageData)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        fileRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUrl = task.result.toString()

                            val userPhotos = HashMap<String,Any>()
                            userPhotos["image3"] = downloadUrl

                            dbRef.child("MoreImages").child(id)
                                .updateChildren(userPhotos)
                        }
                    }
                }
                4 -> {
                    imageView5.setImageURI(imageData)
                    val fileRef = photosRef.child(id + "img4" + ".jpg")
                    val uploadTask = fileRef.putFile(imageData)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        fileRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUrl = task.result.toString()

                            val userPhotos = HashMap<String,Any>()
                            userPhotos["image4"] = downloadUrl

                            dbRef.child("MoreImages").child(id)
                                .updateChildren(userPhotos)
                        }
                    }
                }
                5 -> {
                    imageView6.setImageURI(imageData)
                    val fileRef = photosRef.child(id + "img5" + ".jpg")
                    val uploadTask = fileRef.putFile(imageData)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        fileRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUrl = task.result.toString()

                            val userPhotos = HashMap<String,Any>()
                            userPhotos["image5"] = downloadUrl

                            dbRef.child("MoreImages").child(id)
                                .updateChildren(userPhotos)
                        }
                    }
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}