package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.ConversationActivity
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Chat1
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.squareup.picasso.Picasso

class ChatVerticalAdapter(val context: Context, private val list1: ArrayList<Users>): RecyclerView.Adapter<ChatVerticalAdapter.ChatViewHolder>() {
    var onItemClickListener:UserOnItemClickListener?=null
    class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userName:TextView=view.findViewById(R.id.name_tv)
        val lastMsg:TextView=view.findViewById(R.id.last_chat_tv)
        val img:ImageView=view.findViewById(R.id.circularImageView)
        val root:RelativeLayout=view.findViewById(R.id.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val itemLayout=LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_v_chat,parent,false)
            return ChatViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =list1.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        with(holder){
            Picasso.get().load(list1[position].userImage).into(img)
            userName.text= list1[position].getName()
            //lastMsg.text=list1[position].lastMsg
        }
        holder.root.setOnClickListener {
            onItemClickListener?.onItemClick(list1[position],position)
        }
    }
}
interface UserOnItemClickListener{
    fun onItemClick(item: Users,position: Int)
}