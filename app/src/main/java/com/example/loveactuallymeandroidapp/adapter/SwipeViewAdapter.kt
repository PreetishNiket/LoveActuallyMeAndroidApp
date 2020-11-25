package com.example.loveactuallymeandroidapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.huxq17.swipecardsview.BaseCardAdapter
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class SwipeViewAdapter(private val modelList: ArrayList<Users>,private val age:String) : BaseCardAdapter<List<Users>>() {
    private var type:Int=0
//    override fun getCount(): Int =modelList.size
//


    override fun getCardLayoutId(): Int {
        if (type==1){
            return R.layout.empty_layout
        }
        return R.layout.item_card_view_profile
    }

    override fun onBindData(position: Int, cardview: View) {
        val userImage=cardview.findViewById<ImageView>(R.id.img)
        val userName=cardview.findViewById<TextView>(R.id.userName)
        val ageTV=cardview.findViewById<TextView>(R.id.age)
        val model =modelList[position]
        userName.text=model.getName()
        Picasso.get().load(model.userImage).into(userImage)
        ageTV.text=age
//        val dob=model.getdob()
////        val df=SimpleDateFormat("dd/MM/yyyy")
////        val birthDate=df.format(dob!!)
////        val age=calculateAge(birthDate!!).toString()
//        ageTV.text=dob
    }
    private fun calculateAge(birthDate: Date): Int {
        val birth = Calendar.getInstance()
        birth.time = birthDate
        val today = Calendar.getInstance()
        var yearDifference = (today[Calendar.YEAR]
                - birth[Calendar.YEAR])
        if (today[Calendar.MONTH] < birth[Calendar.MONTH]) {
            yearDifference--
        } else {
            if (today[Calendar.MONTH] == birth[Calendar.MONTH]
                && today[Calendar.DAY_OF_MONTH] < birth[Calendar.DAY_OF_MONTH]
            ) {
                yearDifference--
            }
        }
        return yearDifference
    }


    override fun getCount(): Int {
        return if (modelList.size==0){
            type=1
            modelList.size
        } else{
            modelList.size
        }
    }
}