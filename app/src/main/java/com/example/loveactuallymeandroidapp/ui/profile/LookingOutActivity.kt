package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_looking_out.*

class LookingOutActivity : AppCompatActivity() , View.OnClickListener{

    var Lookingout = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looking_out)
        supportActionBar?.hide()
        cdv1.setOnClickListener(this)
        cdv2.setOnClickListener(this)
        cdv3.setOnClickListener(this)
        cdv4.setOnClickListener(this)
        cdv5.setOnClickListener(this)
        cdv6.setOnClickListener(this)
        skip_l.setOnClickListener {
            startActivity(Intent(this, PoliticalViewsActivity::class.java))
            finish()
        }
        back_l.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cdv1 -> run {
                cdv1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv6.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                Lookingout = "Something Casual"
            }
            R.id.cdv2 -> run {
                cdv2.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv6.setCardBackgroundColor(Color.parseColor("#868686"))
                Lookingout = "Relationship"
            }
            R.id.cdv3 -> {
                cdv3.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv6.setCardBackgroundColor(Color.parseColor("#868686"))
                Lookingout = "Marriage"
            }
            R.id.cdv4 -> {
                cdv4.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv6.setCardBackgroundColor(Color.parseColor("#868686"))
                Lookingout = "Friends"
            }
            R.id.cdv5 -> {
                cdv5.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv6.setCardBackgroundColor(Color.parseColor("#868686"))
                Lookingout = "Exploring"
            }
            R.id.cv6 -> {
                cdv6.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdv2.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv3.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv4.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv5.setCardBackgroundColor(Color.parseColor("#868686"))
                cdv1.setCardBackgroundColor(Color.parseColor("#868686"))
                Lookingout= "Not Sure"
            }


        }
        if (Lookingout.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("lookingout",Lookingout)
            editor.apply()
            startActivity(Intent(this, PoliticalViewsActivity::class.java))
        }

    }
}