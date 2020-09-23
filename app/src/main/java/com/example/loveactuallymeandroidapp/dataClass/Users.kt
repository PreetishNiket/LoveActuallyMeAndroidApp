package com.example.loveactuallymeandroidapp.dataClass


class Users {
    var userImage: String? = null
    private var Name: String? = null
    private var status: String? = null
    private var uid:String?=null
    private var lastMsg:String?=null
    constructor() {

    }

    constructor(name: String?, status: String?, image: String,uid:String?,lastMsg:String?) {
        this.Name = name
        this.status = status
        this.userImage = image
        this.uid=uid
        this.lastMsg=lastMsg
    }

    fun getName(): String? {
        return Name
    }
    fun getUid():String?{
        return uid
    }
    fun getStatus():String?{
        return status
    }
    fun getLastMsg():String?{
        return lastMsg
    }
}
//    val MobileNumber: String,
//    val About: String,
//    val Ability: String,
//    val type: String,
//    val religion:String,
//    val education:String,
//    val gender:String,
//    val dob:String