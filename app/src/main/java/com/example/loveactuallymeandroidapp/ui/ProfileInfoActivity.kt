package com.example.loveactuallymeandroidapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R

class ProfileInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        supportActionBar?.hide()
    }
}