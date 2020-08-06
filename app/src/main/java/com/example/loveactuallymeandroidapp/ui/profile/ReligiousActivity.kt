package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_religious.*

class ReligiousActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religious)
        supportActionBar?.hide()
        skip_r.setOnClickListener {
            startActivity(Intent(this,EducationActivity::class.java))
        }
        back_finish.setOnClickListener {
            finish()
        }

    }
}