package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R

import com.example.loveactuallymeandroidapp.utils.dataClass.LikeYou

class LikeYouAdapter(val context: Context,private val list: ArrayList<LikeYou>):RecyclerView.Adapter<LikeYouAdapter.LikeViewHolder>() {

    inner class LikeViewHolder(view: View):RecyclerView.ViewHolder(view){
            val userImage:ImageView=view.findViewById(R.id.user_img)
            val userName:TextView=view.findViewById(R.id.name_tv)
            val status:TextView=view.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeViewHolder {
        val itemLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_like_you,parent,false)
        return LikeViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
        with(holder){
            userImage.setImageResource(list[position].image)
            userName.text=list[position].userName
            status.text=list[position].status
        }
        holder.userImage.setOnClickListener {
            Toast.makeText(context, "${holder.userName.text}", Toast.LENGTH_SHORT).show()
        }
    }
}