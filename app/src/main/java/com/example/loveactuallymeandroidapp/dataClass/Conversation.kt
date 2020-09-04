package com.example.loveactuallymeandroidapp.dataClass

class Conversation {
    private var sender:String=""
    private var message:String=""
    private var receiver:String=""
    private var messageId:String=""
    constructor()
    {

    }

    constructor(sender: String, message: String, receiver: String, messageId: String) {
        this.sender = sender
        this.message = message
        this.receiver = receiver
        this.messageId = messageId
    }
    fun getSender(): String {
        return sender
    }
    fun setSender(): String {
        return sender
    }
    fun getMessage(): String {
        return message
    }
    fun setMessage(): String {
        return message
    }
}