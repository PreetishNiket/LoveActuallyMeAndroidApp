package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_smoke.*
import kotlinx.android.synthetic.main.activity_work_out.*

class WorkOutActivity : AppCompatActivity() , View.OnClickListener{
    var Workout = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_out)
        supportActionBar?.hide()

        cdActive.setOnClickListener(this)
        cdSometimes.setOnClickListener(this)
        cdNotatall.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cdActive -> run {
                cdActive.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdSometimes.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNotatall.setCardBackgroundColor(Color.parseColor("#868686"))
                Workout = "Active"
            }
            R.id.cdSometimes -> run {
                cdSometimes.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdActive.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNotatall.setCardBackgroundColor(Color.parseColor("#868686"))
                Workout = "Sometimes"
            }
            R.id.cdNotatall -> {
                cdNotatall.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdActive.setCardBackgroundColor(Color.parseColor("#868686"))
                cdSometimes.setCardBackgroundColor(Color.parseColor("#868686"))
                Workout = "Not At All"
            }
        }
        if (Workout.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("workout",Workout)
            editor.apply()
            startActivity(Intent(this, ConnectActivity::class.java))
            finish()
        }
    }
}