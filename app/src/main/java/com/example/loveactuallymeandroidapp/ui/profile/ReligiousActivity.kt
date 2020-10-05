package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_religious.*
import kotlinx.android.synthetic.main.activity_religious.back_finish
import kotlinx.android.synthetic.main.activity_religious.cardView2
import kotlinx.android.synthetic.main.activity_religious.cardView3
import kotlinx.android.synthetic.main.activity_religious.cardView4
import kotlinx.android.synthetic.main.activity_religious.cardView5
import kotlinx.android.synthetic.main.activity_religious.cardView6
import kotlinx.android.synthetic.main.activity_religious.cardView8
import kotlinx.android.synthetic.main.activity_religious.cardView9
import kotlinx.android.synthetic.main.activity_socializing.*
@Suppress("DEPRECATION")
class ReligiousActivity : AppCompatActivity(), View.OnClickListener {
    var religionselected = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religious)
        supportActionBar?.hide()
        cardView1.setOnClickListener(this)
        cardView2.setOnClickListener(this)
        cardView10.setOnClickListener(this)
        cardView9.setOnClickListener(this)
        cardView8.setOnClickListener(this)
        cardView6.setOnClickListener(this)
        cardView5.setOnClickListener(this)
        cardView4.setOnClickListener(this)
        cardView3.setOnClickListener(this)
        cardView11.setOnClickListener(this)
        skip_r.setOnClickListener {
            startActivity(Intent(this,EducationActivity::class.java))
            finish()
        }
        back_finish.setOnClickListener {
            finish()
        }
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.cardView1 -> run {
                cardView1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                religionselected = "Agnostic"
            }
            R.id.cardView2 -> run {
                cardView2.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Atheist"
            }
            R.id.cardView10 -> {
                cardView10.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Buddhist"
            }
            R.id.cardView9 -> {
                cardView9.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Christian"
            }
            R.id.cardView8 -> {
                cardView8.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Hindu"
            }
            R.id.cardView6 -> {
                cardView6.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Jain"
            }
            R.id.cardView5 -> {
                cardView5.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Jewish"
            }
            R.id.cardView4 -> {
                cardView4.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Muslim"
            }
            R.id.cardView3 -> {
                cardView3.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView11.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Spiritual"
            }
            R.id.cardView11 -> {
                cardView11.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView10.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView1.setCardBackgroundColor(Color.parseColor("#868686"))
                religionselected = "Zoroastrian"
            }
        }
        if (religionselected.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("religion",religionselected)
            editor.apply()
            startActivity(Intent(this,EducationActivity::class.java))
        }
    }
}