package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loveactuallymeandroidapp.R
import com.tsongkha.spinnerdatepicker.DatePickerDialog
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder
import kotlinx.android.synthetic.main.activity_profile_details.*

class ProfileDetailsActivity : AppCompatActivity() {
    private lateinit var imageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)
        if (man.isChecked){
            woman.isChecked=false
        }
        if (woman.isChecked){
            man.isChecked=false
        }
        if (intent.extras!=null){
            imageUri=Uri.parse(intent.getStringExtra("image"))
            profile_photo_dt.setImageURI(imageUri)
        }
        back.setOnClickListener {
            finish()
        }
        continueButton.setOnClickListener{
            val name=editTextTextPersonName.text.toString()
            val i=Intent(this,MoreDetailsActivity::class.java)
            i.putExtra("image1",imageUri.toString())
            i.putExtra("name",name)
            startActivity(i)
        }
    }
}