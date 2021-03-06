package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.MainActivity
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_log_in.*


class LogInActivity : AppCompatActivity() {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val db by lazy {
        FirebaseDatabase.getInstance().reference
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        supportActionBar?.hide()
        back_finish.setOnClickListener {
            finish()
        }
        Toast.makeText(this, "Not Working", Toast.LENGTH_SHORT).show()

        //not working
        log_in_button.setOnClickListener {
            val phoneNumber = editTextPhone.text.toString()
            if (phoneNumber.isNotEmpty() && phoneNumber.length == 10) {
                val firstDigit = phoneNumber.substring(0, 1).toInt()
                if ((firstDigit == 6 || firstDigit == 7 || firstDigit == 8 || firstDigit == 9)) {
                    val countryCode = countryCodePicker.selectedCountryCode.toString()
                    val mobileNumber = "+$countryCode$phoneNumber"
                    val id = auth.currentUser?.uid
                    db.child("Users").orderByChild("Mobile_Number").equalTo(mobileNumber)
                        .addListenerForSingleValueEvent(object :
                            ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {

                                    val i = Intent(this@LogInActivity, MainActivity::class.java)
                                    startActivity(i)
                                    finish()
                                    Toast.makeText(
                                        this@LogInActivity,
                                        "Login Successful",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })
                } else {
                    editTextPhone.error = "Enter a valid mobile number"
                }
            } else {
                editTextPhone.error = "Enter a valid mobile number"
            }
        }
    }
}