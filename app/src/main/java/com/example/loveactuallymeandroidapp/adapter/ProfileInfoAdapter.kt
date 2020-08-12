package com.example.loveactuallymeandroidapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.utlis.ProfileInfo

class ProfileInfoAdapter(private val list: ArrayList<ProfileInfo>) :RecyclerView.Adapter<ProfileInfoAdapter.InfoViewHolder>() {

//    var list= arrayOf<ProfileInfo>()
//    set(value) {
//        field=value
//        notifyDataSetChanged()
//    }
    inner class InfoViewHolder(view: View):RecyclerView.ViewHolder(view){
            val title:TextView=view.findViewById(R.id.title_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val itemLayout=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_item,parent,false)
        return InfoViewHolder(itemLayout)
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        with(holder){
            title.text= list[position].title
        }
    }
}