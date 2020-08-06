package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_socializing.*

class SocializingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socializing)
        supportActionBar?.hide()
        imageView.setOnClickListener(this)
        imageView2.setOnClickListener(this)
        back_finish.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View) {
        if(v.id==R.id.imageView){
            if(editTextTextPersonAbout.text.isNullOrEmpty()){
                Toast.makeText(this, "Please enter something about you", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,ReligiousActivity::class.java))
            }
        }
        if(v.id==R.id.imageView2){
            if(editTextTextPersonAbout.text.isNullOrEmpty()){
                Toast.makeText(this, "Please enter something about you", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,ReligiousActivity::class.java))
            }
        }
    }

}