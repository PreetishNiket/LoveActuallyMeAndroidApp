package com.example.loveactuallymeandroidapp.ui.profile

import android.Manifest
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile_ver.*


class ProfileVerActivity : AppCompatActivity() {
    private var storage: FirebaseStorage? = null
    var  selectedImageURI=String
    private var storageReference: StorageReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_ver)
        supportActionBar?.hide()
        storage = FirebaseStorage.getInstance();
        storageReference = storage!!.reference;
        click_photo.setOnClickListener {
                    askPermission()
        }

    }
    companion object{
            const val CAMERA_PERM_CODE=1
        const val CAMERA_REQUEST_CODE=10
    }

    private fun askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERM_CODE)
        }else{
            openCamera()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(
                    this,
                    "Camera Permission is Required to Use Camera",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            // super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
     private fun openCamera(){
        val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
         startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode== CAMERA_REQUEST_CODE){
            val imageUri = data!!.data
            val image:Bitmap= data.extras?.get("data") as Bitmap
            //   profileImage.setImageURI(imageUri);
            if (imageUri != null) {
                uploadImageToFirebase(imageUri)
            }
            profile_ver_iv.setImageBitmap(image)

            val dialog=ProgressDialog(this)
            dialog.setMessage("Verifying")
            dialog.max=50

            profile_ver_iv.handler.postDelayed({
                Toast.makeText(this, "Verified", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
            }, 5500)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun uploadImageToFirebase(imageUri: Uri) {
        // upload image to firebase storage
        val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        val mobile=preference.getString("mobilenumber",null).toString()

        val fileRef = storageReference!!.child("users/$mobile/profile.jpg")
        fileRef.putFile(imageUri).addOnSuccessListener {
            fileRef.downloadUrl.addOnSuccessListener { uri ->
                Picasso.get().load(uri).into(profile_ver_iv)
                val profileRef = storageReference!!.child("users/$mobile/profile.jpg")
                profileRef.downloadUrl.addOnSuccessListener { uri ->
                    Picasso.get().load(uri).into(profile_ver_iv)
                }
            }
        }.addOnFailureListener {
            Toast.makeText(this@ProfileVerActivity, "Failed.", Toast.LENGTH_SHORT).show()
        }
    }
}