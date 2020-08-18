package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            finish()
        }
        back_finish.setOnClickListener {
            finish()
        }
        log_out_button.setOnClickListener {
           val PhoneNumber=editTextPhone.text

            if (!(PhoneNumber.isEmpty()) && PhoneNumber.length.equals(10)) {
                val firstDigit = PhoneNumber.substring(0, 1).toInt()
                if ((firstDigit.equals(6) || firstDigit.equals(7) || firstDigit.equals(8) || firstDigit.equals(9)))
                {

                    startActivity(Intent(this, OtpActivity::class.java))
                    finish()
                }
                else{
                    editTextPhone.setError("Enter a valid mobile number")
                }
            }
            else{
                editTextPhone.setError("Enter a valid mobile number")
            }
        }
        policy_tv.setOnClickListener {
            startActivity(Intent(this,PolicyActivity::class.java))
            finish()
        }


    }
}