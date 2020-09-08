package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.ConversationActivity
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.ChatVerticalAdapter
import com.example.loveactuallymeandroidapp.adapter.UserOnItemClickListener
import com.example.loveactuallymeandroidapp.dataClass.Chat1
import com.example.loveactuallymeandroidapp.dataClass.Chat2
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_chat.view.*


class ChatFragment : Fragment() {
    private val db by lazy {
        FirebaseDatabase.getInstance()
            .reference.child("Users")
    }
    private val list1= arrayListOf(
        Chat1(
            R.drawable.ex_img,
            "Cody Fisher",
            "That’s hilarious, really · July 16"
        ),
        Chat1(
            R.drawable.ex_img1,
            "Penna Fox",
            "Why? · July 16"
        ),
        Chat1(
            R.drawable.ex_img2,
            "Rose Martin",
            "Hey · July 16"
        ),
        Chat1(
            R.drawable.ex_img,
            "Hell Gay",
            "Nice photo! Where are you? · July 16"
        ),
        Chat1(
            R.drawable.ex_img2,
            "Rose Martin",
            "Hey Handsome · July 16"
        ),
        Chat1(
            R.drawable.ex_img2,
            " Debi Kim",
            "Hey dude! How’s it going? · July 16"
        )
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_chat, container, false)
        v.back1.setOnClickListener{
            Toast.makeText(v.context, "No use", Toast.LENGTH_SHORT).show()
        }
        v.rv_v.layoutManager=LinearLayoutManager(v.context)
        v.rv_v.adapter=ChatVerticalAdapter(v.context,list1)
        val adapter1=ChatVerticalAdapter(v.context,list1)
        v.rv_v.adapter=adapter1
        adapter1.onItemClickListener=object :UserOnItemClickListener{
            override fun onItemClick(item: Chat1) {
                startActivity(Intent(v.context, ConversationActivity::class.java))
            }
        }
        v.rv_v.setHasFixedSize(true)

        //horizontal
        v.rv_h.layoutManager=LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)
        firebaseDataHorizontal(v)
        return v
    }
    private fun firebaseDataHorizontal(v:View) {
        val option = FirebaseRecyclerOptions.Builder<Chat2>()
            .setQuery(db, Chat2::class.java)
            .setLifecycleOwner(this)
            .build()
        val firebaseRecyclerAdapter = object: FirebaseRecyclerAdapter<Chat2, MyViewHolder>(option) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val itemView = LayoutInflater.from(v.context).inflate(R.layout.item_rv_h_chat,parent,false)
                return MyViewHolder(itemView)
            }
            override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Chat2) {
                holder.userName.text = model.getName()
                Picasso.get().load(model.getImage()).placeholder(R.drawable.account_circle).into(holder.img)
                holder.itemView.setOnClickListener {
                    val placeId = getRef(position).key.toString()
                    val i=Intent(v.context,ConversationActivity::class.java)
                   i.putExtra("placeid",placeId)
                    startActivity(i)
                }
            }
        }
        v.rv_h.adapter=firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()
    }
}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userName: TextView =itemView.findViewById(R.id.name_tv1)
    val img: ImageView =itemView.findViewById(R.id.circularImageView1)
}