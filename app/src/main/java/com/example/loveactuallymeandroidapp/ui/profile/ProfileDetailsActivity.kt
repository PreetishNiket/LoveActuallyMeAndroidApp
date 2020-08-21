package com.example.loveactuallymeandroidapp.ui.profile

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_profile_details.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ProfileDetailsActivity : AppCompatActivity() {
    var datePickerDialog: DatePickerDialog? = null
    var thisDate= String()
    var gender= String()
    var dateofbirth=String()

    private lateinit var imageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_profile_details)


        val currentDate = SimpleDateFormat("dd/MM/yyyy")
        val todayDate = Date()
        thisDate = currentDate.format(todayDate)


        if (intent.extras!=null){
            imageUri=Uri.parse(intent.getStringExtra("image"))
            profile_photo_dt.setImageURI(imageUri)
        }
        back1.setOnClickListener {
            finish()
        }
        continueButton.setOnClickListener{
            val name=editTextTextPersonName.text.toString()
            val i=Intent(this, MoreDetailsActivity::class.java)

//radio button checking
            if (man.isChecked){
                woman.isChecked=false
                gender="Man"
                Toast.makeText(this@ProfileDetailsActivity, gender, Toast.LENGTH_SHORT).show()
            }
            if (woman.isChecked){
                man.isChecked=false
                gender="Women"
                Toast.makeText(this@ProfileDetailsActivity, gender, Toast.LENGTH_SHORT).show()

            }



            val preference = getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor = preference.edit()
            editor.putString("Gender", gender)
            editor.putString("DateofBirth", dateofbirth)
            editor.putString("Name", name)
            editor.apply()



            i.putExtra("image1", imageUri.toString())
            i.putExtra("name", name)
            startActivity(i)
        }
    }

        fun view(view: View?) {
            val c = Calendar.getInstance()
            val mYear = c[Calendar.YEAR] // current year
            val mMonth = c[Calendar.MONTH] // current month
            val mDay = c[Calendar.DAY_OF_MONTH] // current day
            // date picker dialog
            datePickerDialog = DatePickerDialog(
                this@ProfileDetailsActivity,
                { view, year, monthOfYear, dayOfMonth -> // set day of month , month and year value in the edit text
                    dateofbirth=dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
                    dob.setText(dateofbirth)
                    Toast.makeText(this@ProfileDetailsActivity, dateofbirth, Toast.LENGTH_SHORT).show()
                }, mYear, mMonth, mDay
            )
            datePickerDialog!!.show()
        }
    }
