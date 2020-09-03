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
import com.example.loveactuallymeandroidapp.adapter.ChatHorizontalAdapter
import com.example.loveactuallymeandroidapp.adapter.ChatVerticalAdapter
import com.example.loveactuallymeandroidapp.adapter.UserOnItemClickListener
import com.example.loveactuallymeandroidapp.dataClass.Chat1
import com.example.loveactuallymeandroidapp.dataClass.Chat2
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*


class ChatFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
//    private val list2= arrayListOf(
//        Chat2(
//            R.drawable.ex_img,
//            "Cody Fisher"
//        ),
//        Chat2(
//            R.drawable.ex_img1,
//            "Penna Fox"
//        ),
//        Chat2(
//            R.drawable.ex_img2,
//            "Rose Martin"
//        ),
//        Chat2(
//            R.drawable.ex_img,
//            "Hell Gay"
//        ),
//        Chat2(
//            R.drawable.ex_img2,
//            "Rose Martin"
//        ),
//        Chat2(
//            R.drawable.ex_img2,
//            " Debi Kim"
//        )
//    )
private var list2:List<Chat2>?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_chat, container, false)
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

        list2=ArrayList()

        v.rv_h.layoutManager=LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)
//        v.rv_h.adapter=ChatHorizontalAdapter(v.context, list2 as ArrayList<Chat2>)
//        v.rv_h.setHasFixedSize(true)
        firebaseData(v)

        v.back1.setOnClickListener{
            Toast.makeText(v.context, "No use", Toast.LENGTH_SHORT).show()
        }
        return v
    }


    private fun retrieveAllUsers() {
        val firebaseUserId =FirebaseAuth.getInstance().currentUser?.uid
        val refDb=FirebaseDatabase.getInstance().reference.child("Users")
        refDb.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                (list2 as ArrayList<Chat2>).clear()
                for (snapshot in p0.children)
                {
                    val user=p0.getValue(Chat2::class.java)
//                    if (user!!.uid != firebaseUserId){
//                        (list2 as ArrayList<Chat2>).add(user)
//                    }

                }
            }
            override fun onCancelled(p0: DatabaseError) {}
        })
    }
    val db by lazy {
        FirebaseDatabase.getInstance()
            .reference.child("Users")
    }
    private fun firebaseData(v:View) {
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
                holder.userName.text = model.Name
                Picasso.get().load(model.userImage).placeholder(R.drawable.account_circle).into(holder.img)
                holder.itemView.setOnClickListener {
//                    val placeid = getRef(position).key.toString()
//                    val i=Intent(this@FindFriendsActivity,ProfileActivity::class.java)
//                    i.putExtra("placeid",placeid)
//                    startActivity(i)
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