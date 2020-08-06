package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpViewModel:SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        signUpViewModel=ViewModelProvider(this).get(SignUpViewModel::class.java)
        signUpViewModel.string.observe(this, Observer {
            textView.text=it
        })
        login_text.setOnClickListener {
            startActivity(Intent(this,LogInActivity::class.java))
        }
        back_finish.setOnClickListener {
            finish()
        }
        sign_up_button.setOnClickListener {
            startActivity(Intent(this,OtpActivity::class.java))
        }
        policy_tv.setOnClickListener {
            startActivity(Intent(this,PolicyActivity::class.java))
        }

    }
}