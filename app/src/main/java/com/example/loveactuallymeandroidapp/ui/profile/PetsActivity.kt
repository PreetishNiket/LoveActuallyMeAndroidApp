package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_children.*
import kotlinx.android.synthetic.main.activity_pets.*

class PetsActivity : AppCompatActivity(), View.OnClickListener{

    var Pets = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pets)
        supportActionBar?.hide()
        cdDog.setOnClickListener(this)
        cdCat.setOnClickListener(this)
        cdNone1.setOnClickListener(this)
        cdLots.setOnClickListener(this)
        cdDontwantpet.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cdDog -> run {
                cdDog.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdCat.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdLots.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDontwantpet.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in type selected based on user selection
                Pets = "Dog"
            }
            R.id.cdCat -> run {
                cdCat.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdDontwantpet.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDog.setCardBackgroundColor(Color.parseColor("#868686"))
                cdLots.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone1.setCardBackgroundColor(Color.parseColor("#868686"))
                Pets = "Cat"
            }
            R.id.cdNone1 -> {
                cdNone1.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdDontwantpet.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDog.setCardBackgroundColor(Color.parseColor("#868686"))
                cdCat.setCardBackgroundColor(Color.parseColor("#868686"))
                cdLots.setCardBackgroundColor(Color.parseColor("#868686"))
                Pets = "None"
            }
            R.id.cdLots -> {
                cdLots.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdDog.setCardBackgroundColor(Color.parseColor("#868686"))
                cdCat.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone1.setCardBackgroundColor(Color.parseColor("#868686"))
                cdDontwantpet.setCardBackgroundColor(Color.parseColor("#868686"))
                Pets = "Lots"
            }
            R.id.cdDontwantpet -> {
                cdDontwantpet.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cdDog.setCardBackgroundColor(Color.parseColor("#868686"))
                cdCat.setCardBackgroundColor(Color.parseColor("#868686"))
                cdLots.setCardBackgroundColor(Color.parseColor("#868686"))
                cdNone1.setCardBackgroundColor(Color.parseColor("#868686"))
                Pets = "Don't Want"
            }
        }
        if (Pets.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("pets",Pets)
            editor.apply()
            startActivity(Intent(this, DrinkActivity::class.java))
            finish()
        }
    }
}