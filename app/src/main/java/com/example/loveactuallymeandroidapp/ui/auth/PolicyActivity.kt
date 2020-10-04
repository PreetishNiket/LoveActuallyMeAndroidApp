package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.profile.ProfileVerActivity
import com.example.loveactuallymeandroidapp.ui.profile.ZodiacActivity


class PolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val i = Intent(this@PolicyActivity, ProfileVerActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)


    }
}