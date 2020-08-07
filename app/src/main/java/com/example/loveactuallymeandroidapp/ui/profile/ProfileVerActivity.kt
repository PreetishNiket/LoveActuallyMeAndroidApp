package com.example.loveactuallymeandroidapp.ui.profile

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.loveactuallymeandroidapp.MainActivity
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.auth.SignUpActivity
import kotlinx.android.synthetic.main.activity_profile_ver.*


class ProfileVerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_ver)
        click_photo.setOnClickListener {
                    askPermission()
        }
    }
    companion object{
            const val CAMERA_PERM_CODE=1
        const val CAMERA_REQUEST_CODE=10
    }

    private fun askPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERM_CODE)

        }else{
            openCamera()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
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
            val image:Bitmap= data?.extras?.get("data") as Bitmap
            profile_ver_iv.setImageBitmap(image)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}