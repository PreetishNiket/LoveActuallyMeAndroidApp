package com.example.loveactuallymeandroidapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.huxq17.swipecardsview.BaseCardAdapter

class SwipeViewAdapter(private val modelList: ArrayList<Users>) : BaseCardAdapter<List<Users>>() {
    private var type:Int=0
//    override fun getCount(): Int =modelList.size

    override fun getCardLayoutId(): Int {
        if (type==1){
            return R.layout.empty_layout
        }
        return R.layout.item_card_view_profile
    }

    override fun onBindData(position: Int, cardview: View) {
        val userImage=cardview.findViewById<ImageView>(R.id.img)
        val userName=cardview.findViewById<TextView>(R.id.userName)
        val model =modelList[position]
        userName.text=model.getName()
//        Picasso.get().load(model.userImage).into(userImage)
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