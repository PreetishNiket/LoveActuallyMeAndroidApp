package com.example.loveactuallymeandroidapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R

class PolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)
        supportActionBar?.hide()
    }
}