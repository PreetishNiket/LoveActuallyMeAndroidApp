package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_children.*

class ChildrenActivity : AppCompatActivity(), View.OnClickListener {

    var Children = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_children)
        supportActionBar?.hide()
        cdNone.setOnClickListener(this)
        cdWant.setOnClickListener(this)
        cdDontwant.setOnClickListener(this)
        cdHaveWant.setOnClickListener(this)
        cdHaveDontwant.setOnClickListener(this)
        skip_c.setOnClickListener {
            startActivity(Intent(this, PetsActivity::class.java))
            finish()
        }
        back_c.setOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cdNone -> run {
                cdNone.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdHaveDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                Children = "None"
            }
            R.id.cdWant -> run {
                cdWant.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone.setCardBackgroundColor(Color.parseColor("#868686"))
                Children = "Want"
            }
            R.id.cdDontwant -> {
                cdDontwant.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdNone.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdWant.setCardBackgroundColor(Color.parseColor("#868686"))
                Children = "Don't want"
            }
            R.id.cdHaveWant -> {
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdHaveDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone.setCardBackgroundColor(Color.parseColor("#868686"))
                Children = "Have & Want"
            }
            R.id.cdHaveDontwant -> {
                cdHaveDontwant.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdNone.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDontwant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdHaveWant.setCardBackgroundColor(Color.parseColor("#868686"))
                cdWant.setCardBackgroundColor(Color.parseColor("#868686"))
                Children = "Have & Don't Want"
            }
        }
        if (Children.isNotEmpty()) {
            val preference =
                getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor = preference.edit()
            editor.putString("children", Children)
            editor.apply()
            startActivity(Intent(this, PetsActivity::class.java))
        }

    }
}