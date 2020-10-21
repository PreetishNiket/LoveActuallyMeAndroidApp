package com.example.loveactuallymeandroidapp.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.profile.SocializingActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    var phoneNumber = String()
    var mobileNumber = String()

    companion object {
        const val RC_SIGN_IN = 120
    }

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        mAuth = FirebaseAuth.getInstance()

        supportActionBar?.hide()
        login_text.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }
        google_button.setOnClickListener {
            progressBar.isVisible=true
            signInGoogle()

        }

        back_finish.setOnClickListener {
            finish()
        }

        sign_up_button.setOnClickListener {
            phoneNumber = editTextPhone.text.toString()
            val countryCode = countryCodePicker.selectedCountryCode.toString()
            mobileNumber = "+$countryCode$phoneNumber"

            mobileCheck()

        }
        policy_tv.setOnClickListener {
            startActivity(Intent(this, PolicyActivity::class.java))
            finish()
        }
    }

    private fun signInGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d("TAG", "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.w("TAG", "Google sign in failed", e)

                }
            } else {
                Log.w("TAG", exception.toString())
            }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                    progressBar.isVisible=false
                    val intent = Intent(this, SocializingActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                }

                // ...
            }
    }


    private fun mobileCheck() {

        if (phoneNumber.isNotEmpty() && phoneNumber.length == 10) {
            val firstDigit = phoneNumber.substring(0, 1).toInt()
            if ((firstDigit == 6 || firstDigit == 7 || firstDigit == 8 || firstDigit == 9)) {

                val preference = getSharedPreferences(
                    resources.getString(R.string.app_name),
                    Context.MODE_PRIVATE
                )
                val editor = preference.edit()
                editor.putString("mobilenumber", mobileNumber)
                editor.apply()
                val i = Intent(this, OtpActivity::class.java)
                i.putExtra("phoneNo", mobileNumber)
                startActivity(i)
                finish()
            } else {
                editTextPhone.error = "Enter a valid mobile number"
            }
        } else {
            editTextPhone.error = "Enter a valid mobile number"
        }
    }
}