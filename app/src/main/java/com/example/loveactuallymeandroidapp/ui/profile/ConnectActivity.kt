package com.example.loveactuallymeandroidapp.ui.profile

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.auth.PolicyActivity
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectActivity : AppCompatActivity() , View.OnClickListener {
    var Connect = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)
        supportActionBar?.hide()

        imgAfterWork.setOnClickListener(this)
        imgBreakfast.setOnClickListener(this)
        imgCoffee.setOnClickListener(this)
        imgDinner.setOnClickListener(this)
        imgLunch.setOnClickListener(this)
        imgPhonecall.setOnClickListener(this)
        imgVideocall.setOnClickListener(this)
        skip_co.setOnClickListener {
            startActivity(Intent(this, PolicyActivity::class.java))
            finish()
        }
        back_co.setOnClickListener {
            finish()
        }
        //startActivity(Intent(this, PolicyActivity::class.java))
        //()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imgAfterWork-> run {
            imgAfterWork.setColorFilter(Color.parseColor("#EC6273"))
            imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
            imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
            imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
            imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
            imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
            imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="After Work"

        }
            R.id.imgBreakfast-> run {
                imgAfterWork.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
                imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
                imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
                imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Breakfast"
            }
            R.id.imgCoffee-> run {
                imgCoffee.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
                imgAfterWork.setColorFilter(Color.parseColor("#FFFFFF"))
                imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
                imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Coffee"
            }
            R.id.imgDinner-> run {
                imgDinner.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgAfterWork.setColorFilter(Color.parseColor("#FFFFFF"))
                imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
                imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
                imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Dinner"
            }
            R.id.imgLunch-> run {
                imgLunch.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
                imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
                imgAfterWork.setColorFilter(Color.parseColor("#FFFFFF"))
                imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Lunch"
            }
            R.id.imgPhonecall-> run {
                imgPhonecall.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
                imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
                imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
                imgVideocall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgAfterWork.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Phone Call"
            }
            R.id.imgVideocall-> run {
                imgVideocall.setColorFilter(Color.parseColor("#EC6273"))
                imgBreakfast.setColorFilter(Color.parseColor("#FFFFFF"))
                imgDinner.setColorFilter(Color.parseColor("#FFFFFF"))
                imgCoffee.setColorFilter(Color.parseColor("#FFFFFF"))
                imgLunch.setColorFilter(Color.parseColor("#FFFFFF"))
                imgPhonecall.setColorFilter(Color.parseColor("#FFFFFF"))
                imgAfterWork.setColorFilter(Color.parseColor("#FFFFFF"))
                Connect="Video Call"
            }

        }
        if (Connect.isNotEmpty())
        {
            val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            val editor=preference.edit()
            editor.putString("connect",Connect)
            editor.apply()
            startActivity(Intent(this, PolicyActivity::class.java))
        }

    }
}