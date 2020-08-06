package com.example.loveactuallymeandroidapp.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_education.*

class EducationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
        skip_e.setOnClickListener {
            Toast.makeText(this, "Code Will Be implemented", Toast.LENGTH_SHORT).show()
        }
        back_finish.setOnClickListener {
            finish()
        }
    }
}