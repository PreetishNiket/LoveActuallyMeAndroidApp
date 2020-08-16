package com.example.loveactuallymeandroidapp.ui.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.utlis.dataClass.ProfileInfo
import com.example.loveactuallymeandroidapp.adapter.ProfileInfoAdapter
import kotlinx.android.synthetic.main.activity_profile_info2.*

class ProfileInfo2Activity : AppCompatActivity() {
    private val list= arrayListOf(
        ProfileInfo("Name"),
        ProfileInfo("Gender"),
        ProfileInfo("Age"),
        ProfileInfo("Height"),
        ProfileInfo("Nationality"),
        ProfileInfo("Income"),
        ProfileInfo("Location"),
        ProfileInfo("Speaks"),
        ProfileInfo("Religion"),
        ProfileInfo("Orientation"),
        ProfileInfo("Smoking Habits"),
        ProfileInfo("Drinking Habits"),
        ProfileInfo("Connections"),
        ProfileInfo("Education"),
        ProfileInfo("Occupation")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info2)
        supportActionBar?.hide()
       profile_info_rv.layoutManager=LinearLayoutManager(this)
           profile_info_rv.adapter=ProfileInfoAdapter(list)
        profile_info_rv.setHasFixedSize(true)
        settings.setOnClickListener {
            startActivity(Intent(this,
                SettingsActivity::class.java))
        }
    }
}