package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.huxq17.swipecardsview.BaseCardAdapter
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class SwipeViewAdapter(private val modelList: List<Users>) : BaseCardAdapter<List<Users>>() {

    override fun getCount(): Int =modelList.size

    override fun getCardLayoutId(): Int {
        return R.layout.item_card_view_profile
    }

    override fun onBindData(position: Int, cardview: View) {
        val userImage=cardview.findViewById<ImageView>(R.id.img)
        val userName=cardview.findViewById<TextView>(R.id.userName)
        val model =modelList[position]
        userName.text=model.getName()
        Picasso.get().load(model.userImage).into(userImage)
    }
}