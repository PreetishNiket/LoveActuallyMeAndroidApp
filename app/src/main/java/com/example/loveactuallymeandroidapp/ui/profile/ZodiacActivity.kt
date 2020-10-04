package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_zodiac.*


class ZodiacActivity : AppCompatActivity(), View.OnClickListener {

    var zodiacsign = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zodiac)
        supportActionBar?.hide()
        cv1.setOnClickListener(this)
        cv2.setOnClickListener(this)
        cv3.setOnClickListener(this)
        cv4.setOnClickListener(this)
        cv5.setOnClickListener(this)
        cv6.setOnClickListener(this)
        cv7.setOnClickListener(this)
        cv8.setOnClickListener(this)
        cv9.setOnClickListener(this)
        cv10.setOnClickListener(this)
        cv11.setOnClickListener(this)
        cv12.setOnClickListener(this)

        //startActivity(Intent(this, LookingOutActivity::class.java))
       // finish()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cv1 -> run {
                cv1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                zodiacsign = "Aquarius"
            }
            R.id.cv2 -> run {
                cv2.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign = "Aries"
            }
            R.id.cv3 -> {
                cv3.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign = "Cancer"
            }
            R.id.cv4 -> {
                cv4.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign = "Capricorn"
            }
            R.id.cv5 -> {
                cv5.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign = "Gemini"
            }
            R.id.cv6 -> {
                cv6.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign= "Leo"
            }
            R.id.cv7 -> {
                cv7.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Libra"
            }
            R.id.cv8 -> {
                cv8.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Pisces"
            }
            R.id.cv9 -> {
                cv9.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Sagittarius"
            }
            R.id.cv10 -> {
                cv10.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Scorpio"
            }
            R.id.cv11 -> {
                cv11.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cv12.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Taurus"
            }
            R.id.cv12 -> {
                cv12.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cv6.setCardBackgroundColor(Color.parseColor("#868686"))
                cv7.setCardBackgroundColor(Color.parseColor("#868686"))
                cv8.setCardBackgroundColor(Color.parseColor("#868686"))
                cv9.setCardBackgroundColor(Color.parseColor("#868686"))
                cv10.setCardBackgroundColor(Color.parseColor("#868686"))
                cv11.setCardBackgroundColor(Color.parseColor("#868686"))
                cv1.setCardBackgroundColor(Color.parseColor("#868686"))
                zodiacsign="Virgo"
            }

        }
        if (zodiacsign.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("zodiacsign",zodiacsign)
            editor.apply()
            startActivity(Intent(this, LookingOutActivity::class.java))
            finish()
        }



    }
}