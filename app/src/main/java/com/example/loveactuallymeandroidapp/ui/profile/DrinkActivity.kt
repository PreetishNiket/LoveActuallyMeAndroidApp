package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() , View.OnClickListener{

    var Drinking = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        supportActionBar?.hide()

        cdSocially.setOnClickListener(this)
        cdNever.setOnClickListener(this)
        cdFrequently.setOnClickListener(this)
        skip_d.setOnClickListener {
            startActivity(Intent(this, SmokeActivity::class.java))
            finish()
        }
        back_d.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cdSocially -> run {
                cdSocially.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdNever.setCardBackgroundColor(Color.parseColor("#868686"))
                cdFrequently.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                Drinking = "Socially"
            }
            R.id.cdNever -> run {
                cdNever.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdFrequently.setCardBackgroundColor(Color.parseColor("#868686"))
                cdSocially.setCardBackgroundColor(Color.parseColor("#868686"))
                Drinking = "Never"
            }
            R.id.cdFrequently -> {
                cdFrequently.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdSocially.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNever.setCardBackgroundColor(Color.parseColor("#868686"))
                Drinking = "Frequently"
            }

        }
        if (Drinking.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("drinking",Drinking)
            editor.apply()
            startActivity(Intent(this, SmokeActivity::class.java))
        }
    }
}