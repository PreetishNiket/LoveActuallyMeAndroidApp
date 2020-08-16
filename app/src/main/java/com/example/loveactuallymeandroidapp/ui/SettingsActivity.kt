package com.example.loveactuallymeandroidapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.MainRvAdapter
import com.example.loveactuallymeandroidapp.utlis.dataClass.Section
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    private val sectionList= arrayListOf<Section>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.hide()
        back_set.setOnClickListener {
            finish()
        }
        initData()
        main_rv_set.adapter=MainRvAdapter(sectionList)
        main_rv_set.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }
    private fun initData(){
        val sectionNameOne="Account Setting"
        val sectionItemOne=ArrayList<String>()
        sectionItemOne.add("Phone Number")
        sectionItemOne.add("Email")

        val sectionNameTwo="Notifications"
        val sectionItemTwo=ArrayList<String>()
        sectionItemTwo.add("Email")
        sectionItemTwo.add("Push Notifications")
        sectionItemTwo.add("Team Love")

        val sectionNameThree="Contact Us"
        val sectionItemThree=ArrayList<String>()
        sectionItemThree.add("Help & Support")

        val sectionNameFour="Legal"
        val sectionItemFour=ArrayList<String>()
        sectionItemFour.add("Licenses")
        sectionItemFour.add("Privacy Policy")
        sectionItemFour.add("Terms of Service")
        sectionList.add(Section(sectionNameOne,sectionItemOne))
        sectionList.add(Section(sectionNameTwo,sectionItemTwo))
        sectionList.add(Section(sectionNameThree,sectionItemThree))
        sectionList.add(Section(sectionNameFour,sectionItemFour))
    }
}