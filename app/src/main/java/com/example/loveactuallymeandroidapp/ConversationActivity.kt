package com.example.loveactuallymeandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.adapter.ConVoAdapter
import com.example.loveactuallymeandroidapp.dataClass.Chat2
import com.example.loveactuallymeandroidapp.dataClass.Conversation
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_conversation.*
import kotlinx.android.synthetic.main.activity_conversation.view.*

class ConversationActivity : AppCompatActivity() {
    private val chatref by lazy {
        FirebaseDatabase.getInstance()
            .reference.child("Chats")
    }
    val id=FirebaseAuth.getInstance().currentUser?.uid
    var conVo:ConVoAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        supportActionBar?.hide()
        val receivedId=intent?.getStringExtra("placeid").toString()
        backBtn.setOnClickListener {
            finish()
        }

        //firebaseData()
        send_btn.setOnClickListener {
            var message=send_msg.text.toString()
            if (message.isEmpty()){
                Toast.makeText(this, "Please Write a message", Toast.LENGTH_SHORT).show()
            }
            else{
                sendMessageToUser(id!!,receivedId,message)
                send_msg.text.clear()
            }
        }
        val linearLayoutManager=LinearLayoutManager(this)
        linearLayoutManager.stackFromEnd=true
        chat_rv.layoutManager=linearLayoutManager
        val reference=FirebaseDatabase.getInstance()
            .reference.child("Users").child(receivedId)
            .addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    retrieveMessage(id,receivedId)
                }

                override fun onCancelled(error: DatabaseError) {}
            })

    }
    private var chatList:List<Conversation>?=null
    private fun retrieveMessage(senderId: String?, receivedId: String) {
            chatList=ArrayList()
        val reference=FirebaseDatabase.getInstance()
            .reference.child("Chats")
            .addValueEventListener(object :ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    (chatList as ArrayList<Conversation>).clear()
                    for (snap in snapshot.children){
                        val chat=snap.getValue(Conversation::class.java)
                        if ((chat?.getReceiver() == senderId &&chat?.getSender()==receivedId)
                            ||(chat?.getReceiver()==receivedId&& chat.getSender() ==senderId)){
                            (chatList as ArrayList<Conversation>).add(chat)
                        }
                        conVo=ConVoAdapter(this@ConversationActivity,chatList as ArrayList<Conversation>)
                        chat_rv.adapter=conVo
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    private fun sendMessageToUser(id: String, receivedId: String, message: String) {
        val ref=FirebaseDatabase.getInstance().reference
        val messageKey=ref.push().key
        val messageHashMap=HashMap<String,Any?>()
        messageHashMap["sender"]=id
        messageHashMap["message"]=message
        messageHashMap["receiver"]=receivedId
        messageHashMap["messageId"]=messageKey
        ref.child("Chats").child(messageKey!!).setValue(messageHashMap)
        //notification push
            .addOnCompleteListener {
                if (it.isSuccessful)
                {
                    val chatListRef= FirebaseDatabase.getInstance()
                        .reference.child("Chat List")
                    chatListRef.child(id).child(receivedId)
                        .addListenerForSingleValueEvent(object :ValueEventListener{
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (!snapshot.exists()){
                                    chatListRef.child("id").child(receivedId)
                                }
                                val chatListReceiverRef= FirebaseDatabase.getInstance()
                                    .reference.child("Chat List")
                                    .child(receivedId).child(id)
                                chatListReceiverRef.child("id").setValue(id)
                            }

                            override fun onCancelled(error: DatabaseError) {}
                        })

                }
            }
    }
}