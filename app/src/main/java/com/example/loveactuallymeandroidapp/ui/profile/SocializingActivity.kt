package com.example.loveactuallymeandroidapp.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.auth.PolicyActivity
import kotlinx.android.synthetic.main.activity_socializing.*


@Suppress("DEPRECATION")
class SocializingActivity : AppCompatActivity(), View.OnClickListener {
    var imageselected = String()
    var typeselected = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socializing)
        supportActionBar?.hide()
        imageView.setOnClickListener(this)
        imageView2.setOnClickListener(this)
        cardView.setOnClickListener(this)
        cardView2.setOnClickListener(this)
        cardView3.setOnClickListener(this)
        cardView4.setOnClickListener(this)
        cardView5.setOnClickListener(this)
        cardView6.setOnClickListener(this)
        cardView7.setOnClickListener(this)
        cardView8.setOnClickListener(this)
        cardView9.setOnClickListener(this)
        cardView12.setOnClickListener(this)
        cardView13.setOnClickListener(this)

        back_finish.setOnClickListener {
            finish()
        }


    }

    override fun onClick(v: View) {

        //Used to check whether user is 'able' or 'pwd'
        when (v.getId()) {
            R.id.imageView -> {
                imageView2.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
                imageView.setColorFilter(getResources().getColor(R.color.pink), PorterDuff.Mode.SRC_ATOP)
                //stores the information in image selected based on what user clicked
                imageselected="able"
            }
            R.id.imageView2 -> {
                imageView.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
                imageView2.setColorFilter(getResources().getColor(R.color.pink), PorterDuff.Mode.SRC_ATOP)
                 imageselected="pwd"
            }
            R.id.cardView ->{
                cardView.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                //the type of person is stored in typeselected based on user seletion
                typeselected="Gay"
            }
            R.id.cardView2->{
                cardView2.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Bisexual"
            }
            R.id.cardView3->{
                cardView3.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Demisexual"
            }
            R.id.cardView4->{
                cardView4.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Queer"
            }
            R.id.cardView5->{
                cardView5.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Aromatic"
            }
            R.id.cardView6->{
                cardView6.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Straight"
            }
            R.id.cardView7->{
                cardView7.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="lesbian"
        }
            R.id.cardView8->{
                cardView8.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Asexual"
            }
            R.id.cardView9->{
                cardView9.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView12.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="pansexual"
            }
            R.id.cardView12->{
                cardView12.setCardBackgroundColor(Color.parseColor("#EC6273"))
                cardView2.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView3.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView4.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView5.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView6.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView7.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView8.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView9.setCardBackgroundColor(Color.parseColor("#868686"))
                cardView.setCardBackgroundColor(Color.parseColor("#868686"))
                typeselected="Bicurious"
            }
            R.id.cardView13->{

                if (editTextTextPersonAbout.text.isNotEmpty()&& imageselected.isNotEmpty()&& typeselected.isNotEmpty()){
                    startActivity(Intent(this, ReligiousActivity::class.java))
                    finish()

                }
                else
                {
                    Toast.makeText(applicationContext,"Enter all the details Properly.",Toast.LENGTH_SHORT).show()
                }
            }


            }



        }




    }
