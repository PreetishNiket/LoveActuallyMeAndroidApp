package com.example.loveactuallymeandroidapp.ui.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.MainRvAdapter
import com.example.loveactuallymeandroidapp.utlis.DefaultItemDecorator
import com.example.loveactuallymeandroidapp.dataClass.Section
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.item_footer_settings.*

class SettingsActivity : AppCompatActivity() {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val sectionList= arrayListOf<Section>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.hide()
        back_set.setOnClickListener {
            finish()
        }
        initData()
        main_rv_set.adapter=MainRvAdapter(this,sectionList)
        main_rv_set.addItemDecoration(DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.bottom)))
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