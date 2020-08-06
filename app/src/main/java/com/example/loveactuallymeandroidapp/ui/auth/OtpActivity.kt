package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.profile.SocializingActivity
import kotlinx.android.synthetic.main.activity_otp.*

class OtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()
        verify_button.setOnClickListener {
            startActivity(Intent(this,SocializingActivity::class.java))
        }
        back_finish.setOnClickListener {
            finish()
        }
        pinView.setTextColor(resources.getColor(R.color.white))
    }
}