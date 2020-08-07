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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)
        if (intent.extras!=null){
            val imageUri=Uri.parse(intent.getStringExtra("image"))
            profile_photo.setImageURI(imageUri)
        }
        back.setOnClickListener {
            finish()
        }
        continueButton.setOnClickListener{
            startActivity(Intent(this,MoreDetailsActivity::class.java))
        }
//        spinner.setOnItemClickListener { parent, view, position, id ->
//            val spin=SpinnerDatePickerDialogBuilder()
//                .context(this)
//                .callback(DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//                    Toast.makeText(this, "$year$monthOfYear$dayOfMonth", Toast.LENGTH_SHORT).show()
//                })
//                .spinnerTheme(R.style.NumberPickerStyle)
//                .showTitle(true)
//                .showDaySpinner(true)
//                .build()
//                .show()
//
//        }
    }
}