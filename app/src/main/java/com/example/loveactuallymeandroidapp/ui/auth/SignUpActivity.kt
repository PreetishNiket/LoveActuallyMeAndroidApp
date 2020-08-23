package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.concurrent.TimeUnit

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var signUpViewModel:SignUpViewModel
    private var verificationInProgress = false
    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
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
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d("TAG", "onVerificationCompleted:$credential")

                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w("TAG", "onVerificationFailed", e)

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // ...
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

                // Show a message and update the UI
                // ...
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("TAG", "onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                resendToken = token

            }
        }

        log_out_button.setOnClickListener {
           val PhoneNumber= editTextPhone.text.toString()

            if (!(PhoneNumber.isEmpty()) && PhoneNumber.length.equals(10)) {
                val firstDigit = PhoneNumber.substring(0, 1).toInt()
                if ((firstDigit.equals(6) || firstDigit.equals(7) || firstDigit.equals(8) || firstDigit.equals(9)))
                {

                    val  countrycode=countryCodePicker.selectedCountryCode.toString()
                    val mobilenumber="+"+countrycode+PhoneNumber
                    val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
                    val editor=preference.edit()
                    editor.putString("mobilenumber",mobilenumber)
                    editor.apply()

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        mobilenumber, // Phone number to verify
                        60, // Timeout duration
                        TimeUnit.SECONDS, // Unit of timeout
                        this, // Activity (for callback binding)
                        callbacks) // OnVerificationStateChangedCallbacks


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
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "signInWithCredential:success")

                    val user = task.result?.user

                } else {
                    Log.w("tag" ,"signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                }
            }
    }


}