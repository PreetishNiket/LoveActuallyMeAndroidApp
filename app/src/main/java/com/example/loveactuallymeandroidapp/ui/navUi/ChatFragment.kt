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
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.example.loveactuallymeandroidapp.dataClass.ChatList
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_chat.view.*

class ChatFragment : Fragment() {

    private val db by lazy {
        FirebaseDatabase.getInstance()
            .reference.child("Users")
    }
    private var id: FirebaseUser? = null
    private var usersChatList: List<ChatList>? = null
    private var mUsers: List<Users>? = null
    var chatVerticalAdapter: ChatVerticalAdapter? = null
    lateinit var rv: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_chat, container, false)
        v.back1.setOnClickListener {
            Toast.makeText(v.context, "No use", Toast.LENGTH_SHORT).show()
        }
        //vertical
        rv = v.findViewById(R.id.rv_v)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(context)
        usersChatList = ArrayList()
        id = FirebaseAuth.getInstance().currentUser
        val ref = FirebaseDatabase.getInstance().reference.child("Chat List").child(id!!.uid)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                (usersChatList as ArrayList).clear()
                for (snap in snapshot.children) {
                    val chatList = snap.getValue(ChatList::class.java)
                    (usersChatList as ArrayList).add(chatList!!)
                }
                retrieveChatList()
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        //horizontal
        v.rv_h.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL, false)
        firebaseDataHorizontal(v)
        return v
    }

    fun retrieveChatList() {
        mUsers = ArrayList()
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                (mUsers as ArrayList).clear()

                for (snap in snapshot.children) {

                    val user = snap.getValue(Users::class.java)
                    for (each in usersChatList!!) {
                        if (user!!.getUid().equals(each.getId())) {
                            (mUsers as ArrayList).add(user)
                        }
                    }
                }
                chatVerticalAdapter = ChatVerticalAdapter(context!!, (mUsers as ArrayList<Users>))
                rv.adapter = chatVerticalAdapter
                chatVerticalAdapter!!.notifyDataSetChanged()
                chatVerticalAdapter!!.onItemClickListener = object : UserOnItemClickListener {
                    override fun onItemClick(item: Users, position: Int) {
                        val placeId = item.getUid()
                        val i=Intent(context, ConversationActivity::class.java)
                        i.putExtra("placeid",placeId)
                        startActivity(i)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun firebaseDataHorizontal(v: View) {
        val option = FirebaseRecyclerOptions.Builder<Users>()
            .setQuery(db, Users::class.java)
            .setLifecycleOwner(this)
            .build()
        val firebaseRecyclerAdapter =
            object : FirebaseRecyclerAdapter<Users, MyViewHolder>(option) {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                    val itemView = LayoutInflater.from(v.context)
                        .inflate(R.layout.item_rv_h_chat, parent, false)
                    return MyViewHolder(itemView)
                }

                override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Users) {
                    holder.userName.text = model.getName()
                    Picasso.get().load(model.userImage).placeholder(R.drawable.account_circle)
                        .into(holder.img)
                    holder.itemView.setOnClickListener {
                        val placeId = getRef(position).key.toString()
                        val i = Intent(v.context, ConversationActivity::class.java)
                        i.putExtra("placeid", placeId)
                        startActivity(i)
                    }
                }
            }
        v.rv_h.adapter = firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.name_tv1)
        val img: ImageView = itemView.findViewById(R.id.circularImageView1)
    }
}

