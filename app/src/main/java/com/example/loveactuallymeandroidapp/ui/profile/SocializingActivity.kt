package com.example.loveactuallymeandroidapp.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loveactuallymeandroidapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_socializing.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class SocializingActivity : AppCompatActivity(), View.OnClickListener {
    var imageselected = String()
    var about = String()
    var typeselected = String()
    var thisDate = String()
    var localTime = String()

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socializing)
        supportActionBar?.hide()
        val currentDate = SimpleDateFormat("dd/MM/yyyy")
        val todayDate = Date()
        thisDate = currentDate.format(todayDate).toString()
        val cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"))
        val currentLocalTime = cal.time
        val date: DateFormat = SimpleDateFormat("HH:mm a")
        // you can get seconds by adding  "...:ss" to it
        // you can get seconds by adding  "...:ss" to it
        date.timeZone = TimeZone.getTimeZone("GMT+5:30")
        localTime = date.format(currentLocalTime).toString()

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
                imageView2.setColorFilter(
                    getResources().getColor(R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                imageView.setColorFilter(
                    getResources().getColor(R.color.pink),
                    PorterDuff.Mode.SRC_ATOP
                )
                //stores the information in image selected based on what user clicked
                imageselected = "able"
            }
            R.id.imageView2 -> {
                imageView.setColorFilter(
                    getResources().getColor(R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                imageView2.setColorFilter(
                    getResources().getColor(R.color.pink),
                    PorterDuff.Mode.SRC_ATOP
                )
                imageselected = "pwd"
            }
            R.id.cardView -> {
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
                typeselected = "Gay"
            }
            R.id.cardView2 -> {
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
                typeselected = "Bisexual"
            }
            R.id.cardView3 -> {
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
                typeselected = "Demisexual"
            }
            R.id.cardView4 -> {
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
                typeselected = "Queer"
            }
            R.id.cardView5 -> {
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
                typeselected = "Aromatic"
            }
            R.id.cardView6 -> {
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
                typeselected = "Straight"
            }
            R.id.cardView7 -> {
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
                typeselected = "lesbian"
            }
            R.id.cardView8 -> {
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
                typeselected = "Asexual"
            }
            R.id.cardView9 -> {
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
                typeselected = "pansexual"
            }
            R.id.cardView12 -> {
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
                typeselected = "Bicurious"
            }
            R.id.cardView13 -> {
                about = editTextTextPersonAbout.text.toString()
                if (about.isNotEmpty() && imageselected.isNotEmpty() && typeselected.isNotEmpty()) {
                    val preference = getSharedPreferences(
                        resources.getString(R.string.app_name),
                        Context.MODE_PRIVATE
                    )

                    val editor = preference.edit()
                    editor.putString("ability", imageselected)
                    editor.putString("about", about)
                    editor.putString("type", typeselected)
                    //mobile = preference.getString("mobilenumber", null).toString()
                    editor.apply()
                    startActivity(Intent(this, ReligiousActivity::class.java))
                    //Toast.makeText(applicationContext, mobile, Toast.LENGTH_SHORT).show()

                }


            }
            //val preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
            // mobile= preference.getString("mobilenumber",null).toString()
            // textView.setText(mobile)
        }

    }
}
