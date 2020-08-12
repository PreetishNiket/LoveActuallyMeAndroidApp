package com.example.loveactuallymeandroidapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R

class LikeYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like_you)
        supportActionBar?.hide()
    }
}