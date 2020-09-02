package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.profile.SocializingActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_otp.*
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity() {
    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()

        phoneNumber = intent.getStringExtra("phoneNo").toString()

        back_finish.setOnClickListener {
            finish()
        }
        sendCode(phoneNumber)
        verify_button.setOnClickListener {
            val code = pinView.text.toString()
            if (code.isNotEmpty()) {
                verifyCode(code)
            }
        }
    }

    //global
    private lateinit var storedVerificationId: String
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val db by lazy {
        FirebaseDatabase.getInstance().reference.child("Users")
    }
    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            val code = credential.smsCode
            if (code != null) {
                pinView.setText(code)
                verifyCode(code)
            }
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            Toast.makeText(this@OtpActivity, exception.message, Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(
            verificationId: String,
            forceResendingToken: PhoneAuthProvider.ForceResendingToken
        ) {
            super.onCodeSent(verificationId, forceResendingToken)
            storedVerificationId = verificationId
        }
    }

    private fun sendCode(phoneNumber: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, this, callbacks)
    }

    private fun verifyCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    //    var id:String?=""
    private fun signInWithPhoneAuthCredential(phoneAuthCredential: PhoneAuthCredential) {
        auth.signInWithCredential(phoneAuthCredential)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {

                    val id = auth.currentUser?.uid

                    val usersHashMap = HashMap<String, String?>()
                    usersHashMap["uid"] = id
                    usersHashMap["phoneNumber"] = phoneNumber
                    usersHashMap["profile_photo"] =
                        "https://firebasestorage.googleapis.com/v0/b/loveactuallymeandroidapp.appspot.com/o/profile%20verification.jpg?alt=media&token=8b4e5865-396a-40c3-9cd0-e0edf9e23cd4"
                    usersHashMap["status"] = "offline"
                    db.child(id!!).setValue(usersHashMap).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(
                                this,
                                SocializingActivity::class.java
                            )
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        }
                    }

                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}