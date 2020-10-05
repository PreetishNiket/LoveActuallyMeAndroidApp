package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_political_views.*

class PoliticalViewsActivity : AppCompatActivity(), View.OnClickListener {
    var Politicalview = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_political_views)
        supportActionBar?.hide()
        cdApolitical.setOnClickListener(this)
        cdModerate.setOnClickListener(this)
        cdLiberal.setOnClickListener(this)
        cdConservative.setOnClickListener(this)
        skip_po.setOnClickListener {
            startActivity(Intent(this, ChildrenActivity::class.java))
            finish()
        }
        back_po.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
                R.id.cdApolitical -> run {
                    cdApolitical.setCardBackgroundColor(Color.parseColor("#EC6273"))
                    cdLiberal.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdConservative.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdModerate.setCardBackgroundColor(Color.parseColor("#868686"))
                    //the type of person is stored in type selected based on user selection
                    Politicalview = "Apolitical"
                }
                R.id.cdModerate -> run {
                    cdModerate.setCardBackgroundColor(Color.parseColor("#EC6273"))
                    cdConservative.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdApolitical.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdLiberal.setCardBackgroundColor(Color.parseColor("#868686"))
                    Politicalview = "Moderate"
                }
                R.id.cdLiberal -> {
                    cdLiberal.setCardBackgroundColor(Color.parseColor("#EC6273"))
                    cdModerate.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdApolitical.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdConservative.setCardBackgroundColor(Color.parseColor("#868686"))
                    Politicalview = "Liberal"
                }
                R.id.cdConservative -> {
                    cdConservative.setCardBackgroundColor(Color.parseColor("#EC6273"))
                    cdApolitical.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdModerate.setCardBackgroundColor(Color.parseColor("#868686"))
                    cdLiberal.setCardBackgroundColor(Color.parseColor("#868686"))
                    Politicalview = "Conservative"
                }
            }
        if (Politicalview.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("politicalview",Politicalview)
            editor.apply()
            startActivity(Intent(this, ChildrenActivity::class.java))
        }
        }
    }
