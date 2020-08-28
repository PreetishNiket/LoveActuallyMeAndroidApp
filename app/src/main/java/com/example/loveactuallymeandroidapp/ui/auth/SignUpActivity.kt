package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        login_text.setOnClickListener {
            startActivity(Intent(this,LogInActivity::class.java))
            finish()
        }
        back_finish.setOnClickListener {
            finish()
        }

        log_out_button.setOnClickListener {
           val phoneNumber= editTextPhone.text.toString()
            if (phoneNumber.isNotEmpty() && phoneNumber.length == 10) {
                val firstDigit = phoneNumber.substring(0, 1).toInt()
                if ((firstDigit == 6 || firstDigit == 7 || firstDigit == 8 || firstDigit == 9))
                {
                    val  countryCode=countryCodePicker.selectedCountryCode.toString()
                    val mobileNumber= "+$countryCode$phoneNumber"

                    val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
                    val editor=preference.edit()
                    editor.putString("mobilenumber",mobileNumber)
                    editor.apply()
                    val i =Intent(this, OtpActivity::class.java)
                    i.putExtra("phoneNo",mobileNumber)
                    startActivity(i)
                    finish()
                }
                else{
                    editTextPhone.error = "Enter a valid mobile number"
                }
            }
            else{
                editTextPhone.error = "Enter a valid mobile number"
            }
        }
        policy_tv.setOnClickListener {
            startActivity(Intent(this,PolicyActivity::class.java))
            finish()
        }
    }
}