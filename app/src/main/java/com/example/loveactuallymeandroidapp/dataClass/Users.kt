package com.example.loveactuallymeandroidapp.dataClass


class Users {
    var userImage: String? = null
    private var name: String? = null
    private var status: String? = null
    private var uid:String?=null
    constructor() {

    }

    constructor(name: String?, status: String?, image: String,uid:String?) {
        this.name = name
        this.status = status
        this.userImage = image
        this.uid=uid
    }

    fun getName(): String? {
        return name
    }
    fun getUid():String?{
        return uid
    }
    fun getStatus():String?{
        return status
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