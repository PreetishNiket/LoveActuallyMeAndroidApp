package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Conversation
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

class ChatVerticalAdapter(val context: Context, private val list1: ArrayList<Users>): RecyclerView.Adapter<ChatVerticalAdapter.ChatViewHolder>() {
    var onItemClickListener:UserOnItemClickListener?=null
    class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userName:TextView=view.findViewById(R.id.name_tv)
        val lastMsg:TextView=view.findViewById(R.id.last_chat_tv)
        val img:ImageView=view.findViewById(R.id.circularImageView)
        val root:RelativeLayout=view.findViewById(R.id.root)
        val status:ImageView=view.findViewById(R.id.status_v)
        val tv:TextView=view.findViewById(R.id.noChats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val itemLayout=LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_v_chat,parent,false)
            return ChatViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =list1.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        if (list1.size==0){
        holder.tv.visibility=View.VISIBLE
        }
        with(holder){
            Picasso.get().load(list1[position].userImage).into(img)
            userName.text= list1[position].getName()
        }
        retrieveLastMessage(list1[position].getUid(),holder.lastMsg)
        if (list1[position].getStatus()=="online"){
            holder.status.visibility=View.VISIBLE
        }
        if (list1[position].getStatus()=="offline"){
            holder.status.visibility=View.GONE
        }
        holder.root.setOnClickListener {
            onItemClickListener?.onItemClick(list1[position],position)
        }

    }
    var lastMessage:String=""
    private fun retrieveLastMessage(chatUserId: String?, lastMsg: TextView) {
        lastMessage="defaultMsg"
        val firebaseUser=FirebaseAuth.getInstance().currentUser
        val reference=FirebaseDatabase.getInstance().reference.child("Chats")
        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                    val chat:Conversation?=snap.getValue(Conversation::class.java)
                    if (firebaseUser!=null && chat!=null){
                        if ((chat.getReceiver()==firebaseUser.uid &&chat.getSender()==chatUserId)
                            ||(chat.getReceiver()==chatUserId && chat.getSender()==firebaseUser.uid)){
                                    lastMessage=chat.getMessage()
                        }
                    }
                }
                when(lastMessage){
                    "defaultMsg"-> lastMsg.text="No Messages"
                    else->lastMsg.text=lastMessage
                }
                lastMessage="defaultMsg"
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
interface UserOnItemClickListener{
    fun onItemClick(item: Users,position: Int)
}