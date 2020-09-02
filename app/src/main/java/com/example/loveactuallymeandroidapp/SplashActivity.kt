package com.example.loveactuallymeandroidapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.ui.auth.SignUpActivity
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    var fauth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        fauth = FirebaseAuth.getInstance()
        if (fauth?.currentUser != null) {
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },3000)
        } else {
            Handler().postDelayed({
                startActivity(Intent(this, SignUpActivity::class.java))
                finish()
            },3000)

        }
    }
}