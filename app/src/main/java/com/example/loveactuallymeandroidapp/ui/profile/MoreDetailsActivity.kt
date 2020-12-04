package com.example.loveactuallymeandroidapp.ui.profile


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loveactuallymeandroidapp.MainActivity
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_more_details.*
import kotlinx.android.synthetic.main.activity_more_details.tvname

class MoreDetailsActivity : AppCompatActivity(), View.OnClickListener {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val dbRef by lazy {
        FirebaseDatabase.getInstance().reference
    }
    private val sRef by lazy {
        FirebaseStorage.getInstance().reference.child("Profile Image")
    }


    private lateinit var imageUri: Uri
    private lateinit var id: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_details)
        supportActionBar?.hide()
        val userName = intent.getStringExtra("name")
        tvname.text = userName
        if (intent.extras != null) {
            imageUri = Uri.parse(intent.getStringExtra("image1"))
            profile_photo1.setImageURI(imageUri)
            imageView1.setImageURI(imageUri)
        }


        getStartedButton.setOnClickListener {

            val preference =
                getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val mobile = preference.getString("mobilenumber", null).toString()
            val about = preference.getString("about", null).toString()
            val ability = preference.getString("ability", null).toString()
            val type = preference.getString("type", null).toString()
            val religion = preference.getString("religion", null).toString()
            val education = preference.getString("education", null).toString()
            val gender = preference.getString("gender", null).toString()
            val dob = preference.getString("dateofbirth", null).toString()
            val name = preference.getString("name", null).toString()
            val Zodiacsign = preference.getString("zodiacsign", null).toString()
            val Lookingout = preference.getString("lookingout", null).toString()
            val Politicalview = preference.getString("politicalview", null).toString()
            val Children = preference.getString("children", null).toString()
            val Pets = preference.getString("pets", null).toString()
            val Drinking = preference.getString("drinking", null).toString()
            val Smoking = preference.getString("smoking", null).toString()
            val Workout = preference.getString("workout", null).toString()
            val Connect = preference.getString("connect", null).toString()
            val userDetails: HashMap<String, String?> = hashMapOf(
                "Mobile_Number" to mobile,
                "About" to about,
                "Ability" to ability,
                "Type_of_person" to type,
                "Religious_Belief" to religion,
                "Education" to education,
                "Gender" to gender,
                "Date_of_Birth" to dob,
                "Name" to name,
                "Zodiacsign" to Zodiacsign,
                "Lookingout" to Lookingout,
                "Politicalview" to Politicalview,
                "Children" to Children,
                "Pets" to Pets,
                "Drinking" to Drinking,
                "Smoking" to Smoking,
                "Workout" to Workout,
                "Connect" to Connect,
            )
            val db = FirebaseFirestore.getInstance()

            db.collection("users").document(mobile)
                .set(userDetails)
                .addOnSuccessListener {
                    Toast.makeText(
                        applicationContext,
                        "Profile Created Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        applicationContext,
                        "Error",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            id = auth.currentUser!!.uid
            userDetails["userImage"] =
                "https://firebasestorage.googleapis.com/v0/b/loveactuallymeandroidapp.appspot.com/o/profile%20verification.jpg?alt=media&token=8b4e5865-396a-40c3-9cd0-e0edf9e23cd4"
            userDetails["status"] = "offline"
            userDetails["uid"] = id
            dbRef.child("Users").child(id).setValue(userDetails)

            dbRef.child("UsersCopy").child(id).setValue(userDetails)

            val fileRef = sRef.child("$id.jpg")
            val uploadTask = fileRef.putFile(imageUri)
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
                    dbRef.child("Users").child(id).child("userImage").setValue(downloadUrl)
//                    userDetails["userImage"]= downloadUrl
//                    dbRef.child("Users").child(id).updateChildren(userDetails)
                }
            }
        }

        back1.setOnClickListener {
            finish()
        }

        imageView2.setOnClickListener(this)
        imageView3.setOnClickListener(this)
        imageView4.setOnClickListener(this)
        imageView5.setOnClickListener(this)
        imageView6.setOnClickListener(this)
    }

    companion object {
        const val GALLERY_PICKER = 1;
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

    private fun galleryPick() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Pick An Image"), GALLERY_PICKER)
    }

    //storage Reference
    private val photosRef by lazy {
        FirebaseStorage.getInstance().reference.child("MoreImages")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        id = auth.currentUser!!.uid
        if (requestCode == GALLERY_PICKER && resultCode == RESULT_OK && data != null) {
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