package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_education.*

class EducationActivity : AppCompatActivity(), View.OnClickListener {
    var educationselected = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
        supportActionBar?.hide()
        cardView1.setOnClickListener(this)
        cardView2.setOnClickListener(this)
        cardView4.setOnClickListener(this)
        cardView3.setOnClickListener(this)
        cardView6.setOnClickListener(this)
        cardView5.setOnClickListener(this)
        cardView7.setOnClickListener(this)
        skip_e.setOnClickListener {
            startActivity(Intent(this, ProfileVerActivity::class.java))
            finish()
        }
        back_finish.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.cardView1 -> run {
                cardView1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in typeselected based on user seletion
                educationselected = "Agnostic"
            }
            R.id.cardView2 -> run {
                cardView2.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Atheist"
            }
            R.id.cardView4 -> {
                cardView4.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Buddhist"
            }
            R.id.cardView3 -> {
                cardView3.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Christian"
            }
            R.id.cardView6 -> {
                cardView6.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Hindu"
            }
            R.id.cardView5 -> {
                cardView5.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Jain"
            }
            R.id.cardView7 -> {
                cardView7.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                educationselected = "Jewish"
            }

        }
        if (educationselected.isNotEmpty())
        {
            startActivity(Intent(this, ProfileVerActivity::class.java))
            finish()
        }


    }
}
