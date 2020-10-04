package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_drink.*
import kotlinx.android.synthetic.main.activity_drink.cdNever
import kotlinx.android.synthetic.main.activity_drink.cdSocially
import kotlinx.android.synthetic.main.activity_smoke.*

class SmokeActivity : AppCompatActivity() , View.OnClickListener{
    var Smoking = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smoke)
        supportActionBar?.hide()

        cdSocially1.setOnClickListener(this)
        cdNever1.setOnClickListener(this)
        cdRegularly.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cdSocially1 -> run {
                cdSocially1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdNever1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdRegularly.setCardBackgroundColor(Color.parseColor("#868686"))
                Smoking = "Socially"
            }
            R.id.cdNever1 -> run {
                cdNever1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdRegularly.setCardBackgroundColor(Color.parseColor("#868686"))
                cdSocially1.setCardBackgroundColor(Color.parseColor("#868686"))
                Smoking = "Never"
            }
            R.id.cdRegularly -> {
                cdRegularly.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdSocially1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNever1.setCardBackgroundColor(Color.parseColor("#868686"))
                Smoking = "Regularly"
            }

        }
        if (Smoking.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("smoking",Smoking)
            editor.apply()
            startActivity(Intent(this, WorkOutActivity::class.java))
            finish()
        }
    }
}