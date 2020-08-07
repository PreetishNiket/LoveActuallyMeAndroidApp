package com.example.loveactuallymeandroidapp.ui.profile

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_more_details.*
import kotlinx.android.synthetic.main.activity_profile_details.*

class MoreDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_details)
//        if (intent.extras!=null){
//            val imageUri= Uri.parse(intent.getStringExtra("image"))
//            profile_photo1.setImageURI(imageUri)
//        }
    }
}