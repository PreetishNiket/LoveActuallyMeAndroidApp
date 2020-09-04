package com.example.loveactuallymeandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

class ConversationActivity : AppCompatActivity() {
    private val chatref by lazy {
        FirebaseDatabase.getInstance()
            .reference.child("Chats")
    }
    val id=FirebaseAuth.getInstance().currentUser?.uid
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
        val reference=FirebaseDatabase.getInstance()
            .reference.child("Users").child("")

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