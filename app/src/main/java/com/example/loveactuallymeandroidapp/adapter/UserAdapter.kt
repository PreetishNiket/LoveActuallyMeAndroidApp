package com.example.loveactuallymeandroidapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.utils.dataClass.User
import kotlinx.android.synthetic.main.item_card_view_profile.view.*

class UserAdapter(private val list: ArrayList<User>):BaseAdapter() {
    override fun getCount(): Int =list.size

    override fun getItem(pos: Int): Any =list[pos]

    override fun getItemId(pos: Int): Long =pos.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater=LayoutInflater.from(parent?.context)
        val view:View
        view=convertView?:inflater.inflate(R.layout.item_card_view_profile,parent,false)
       // view.userImg.setImageResource(list[pos].userImage)
        return view
    }
}