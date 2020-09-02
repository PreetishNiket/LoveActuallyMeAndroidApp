package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    var phoneNumber= String()
    var mobileNumber =String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        login_text.setOnClickListener {
            startActivity(Intent(this,LogInActivity::class.java))
        }
        back_finish.setOnClickListener {
            finish()
        }

        sign_up_button.setOnClickListener {
            phoneNumber= editTextPhone.text.toString()
            val countryCode=countryCodePicker.selectedCountryCode.toString()
            mobileNumber= "+$countryCode$phoneNumber"

            mobilecheck()

        }
        policy_tv.setOnClickListener {
            startActivity(Intent(this,PolicyActivity::class.java))
            finish()
        }
    }
    fun mobilecheck()
    {

        if (phoneNumber.isNotEmpty() && phoneNumber.length == 10) {
            val firstDigit = phoneNumber.substring(0, 1).toInt()
            if ((firstDigit == 6 || firstDigit == 7 || firstDigit == 8 || firstDigit == 9))
            {

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
}