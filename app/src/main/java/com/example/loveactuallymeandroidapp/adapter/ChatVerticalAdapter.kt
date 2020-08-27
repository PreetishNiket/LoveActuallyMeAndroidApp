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
import com.example.loveactuallymeandroidapp.utlis.dataClass.Chat1

class ChatVerticalAdapter(val context: Context, private val list1: ArrayList<Chat1>): RecyclerView.Adapter<ChatVerticalAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
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
            img.setImageResource(list1[position].userImage)
            userName.text= list1[position].Username
            lastMsg.text=list1[position].lastMsg
        }
        holder.root.setOnClickListener {
// <<<<<<< HEAD
            Toast.makeText(context, "This will Open chat Activity which will only be implemented when we will implement backend", Toast.LENGTH_SHORT).show()
// =======
           onItemClickListener?.onItemClick(list1[position])
// >>>>>>> bccc6efc1850fe9ff19dda55303e7621a68eed85
        }
    }
}