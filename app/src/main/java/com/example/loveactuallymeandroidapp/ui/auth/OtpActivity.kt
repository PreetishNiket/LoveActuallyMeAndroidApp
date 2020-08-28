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
import kotlinx.android.synthetic.main.activity_otp.*
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()

        val phoneNumber = intent.getStringExtra("phoneNo")

        back_finish.setOnClickListener {
            finish()
        }
        if (phoneNumber != null) {
            sendCode(phoneNumber)
        }
        verify_button.setOnClickListener {
            val code=pinView.text.toString()
            if (code.isNotEmpty()){
                verifyCode(code)
            }
        }
    }
    //global
    private lateinit var storedVerificationId:String
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val callbacks=object :PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            val code= credential.smsCode
            if (code!=null){
                pinView.setText(code)
                verifyCode(code)
            }
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            Toast.makeText(this@OtpActivity,exception.message, Toast.LENGTH_SHORT).show()
        }
        override fun onCodeSent(verificationId: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(verificationId, forceResendingToken)
            storedVerificationId=verificationId
        }
    }

    private fun sendCode(phoneNumber: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, this, callbacks)
    }
    private fun verifyCode(code:String){
        val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
        signInWithPhoneAuthCredential(credential)
    }
    private fun signInWithPhoneAuthCredential(phoneAuthCredential: PhoneAuthCredential) {
        auth.signInWithCredential(phoneAuthCredential)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){

                    val intent=Intent(this,
                        SocializingActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}