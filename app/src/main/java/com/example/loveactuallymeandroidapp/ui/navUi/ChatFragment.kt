package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.ConversationActivity
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.ChatHorizontalAdapter
import com.example.loveactuallymeandroidapp.adapter.ChatVerticalAdapter
import com.example.loveactuallymeandroidapp.adapter.UserOnItemClickListener
import com.example.loveactuallymeandroidapp.adapter.UserOnItemClickListener1
import com.example.loveactuallymeandroidapp.utils.dataClass.Chat1
import com.example.loveactuallymeandroidapp.utils.dataClass.Chat2
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
    private val list2= arrayListOf(
        Chat2(
            R.drawable.ex_img,
            "Cody Fisher"
        ),
        Chat2(
            R.drawable.ex_img1,
            "Penna Fox"
        ),
        Chat2(
            R.drawable.ex_img2,
            "Rose Martin"
        ),
        Chat2(
            R.drawable.ex_img,
            "Hell Gay"
        ),
        Chat2(
            R.drawable.ex_img2,
            "Rose Martin"
        ),
        Chat2(
            R.drawable.ex_img2,
            " Debi Kim"
        )
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_chat, container, false)

        v.rv_v.layoutManager=LinearLayoutManager(v.context)
        val adapter1=ChatVerticalAdapter(v.context,list1)
        v.rv_v.adapter=adapter1
        adapter1.onItemClickListener=object :UserOnItemClickListener{
            override fun onItemClick(item: Chat1) {
                startActivity(Intent(v.context, ConversationActivity::class.java))
            }

        }

        v.rv_v.setHasFixedSize(true)

        v.rv_h.layoutManager=LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)
        val adapter2=ChatHorizontalAdapter(v.context,list2)
        v.rv_h.adapter=adapter2
        adapter2.onItemClickListener1=object :UserOnItemClickListener1{
            override fun onItemClick(list: Chat2) {
                Toast.makeText(v.context, "Item", Toast.LENGTH_SHORT).show()
            }
        }
        v.rv_h.setHasFixedSize(true)
        v.back1.setOnClickListener{
            Toast.makeText(v.context, "No use", Toast.LENGTH_SHORT).show()
        }

        return v
    }
}