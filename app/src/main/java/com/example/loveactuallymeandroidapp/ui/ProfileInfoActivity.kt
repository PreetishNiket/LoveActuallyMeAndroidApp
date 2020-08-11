package com.example.loveactuallymeandroidapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_profile_info.*

class ProfileInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        supportActionBar?.hide()
        set_pro.setOnClickListener {
            startActivity(Intent(this,ProfileInfo2Activity::class.java))
        }
        back1.setOnClickListener {
            finish()
        }
    }
}