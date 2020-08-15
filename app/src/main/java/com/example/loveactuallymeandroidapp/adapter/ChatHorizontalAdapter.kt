package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.utlis.Chat2

class ChatHorizontalAdapter(val context: Context, private val list2: ArrayList<Chat2>): RecyclerView.Adapter<ChatHorizontalAdapter.ChatViewHolder>() {
    inner class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userName: TextView =view.findViewById(R.id.name_tv1)
        val img: ImageView =view.findViewById(R.id.circularImageView1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_h_chat,parent,false)
        return ChatViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =list2.size

    override fun onBindViewHolder(holder:ChatViewHolder, position: Int) {
        with(holder){
            img.setImageResource(list2[position].userImage)
            userName.text= list2[position].Username
        }
    }
}