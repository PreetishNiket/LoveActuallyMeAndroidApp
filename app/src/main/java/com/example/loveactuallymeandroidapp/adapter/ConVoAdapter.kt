package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Chat2
import com.example.loveactuallymeandroidapp.dataClass.Conversation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class ConVoAdapter(val context: Context,
                   private val list2: ArrayList<Conversation>) :
    RecyclerView.Adapter<ConVoAdapter.ChatViewHolder>() {
    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val showTextMessage:TextView=view.findViewById(R.id.show_text_message)
        //val show_text_message:TextView=view.findViewById(R.id.show_text_message_left)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ChatViewHolder {
        return if (position==1){
            val itemLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_message_right, parent, false)
             ChatViewHolder(itemLayout)
        }
        else{
            val itemLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_message_left, parent, false)
            ChatViewHolder(itemLayout)
        }
    }

    override fun getItemCount(): Int = list2.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat=list2[position]
        if (chat.getSender()==auth?.uid){
            holder.showTextMessage.visibility=View.VISIBLE
            holder.showTextMessage.text=chat.getMessage()
        }
        else if (chat.getSender()!=auth?.uid){
            holder.showTextMessage.visibility=View.VISIBLE
            holder.showTextMessage.text=chat.getMessage()
        }
    }
    private val auth by lazy{
        FirebaseAuth.getInstance().currentUser
    }
    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        return if (list2[position].getSender() == auth?.uid){
            1
        } else{
            0
        }
    }
}