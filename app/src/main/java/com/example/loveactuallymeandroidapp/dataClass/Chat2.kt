package com.example.loveactuallymeandroidapp.dataClass

import com.example.loveactuallymeandroidapp.R

class Chat2{
    var userImage: String?=null
    var Name: String?=null
    var status:String?=null
    public constructor()
    {

    }
    constructor(name: String?, status: String?, image: String) {
        this.Name = name
        this.status = status
        this.userImage = image
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

//class Chat2 {
//    var uid: String = ""
//    var userImage: Int = 0
//    var Username: String = ""
//
//    constructor() {}
//    constructor(uid: String, userImage: Int, Username: String) {
//        this.uid = uid
//        this.userImage = userImage
//        this.Username = Username
//    }
//
//    @JvmName("getUid1")
//    fun getUid(): String {
//        return uid
//    }
//
//    @JvmName("setUid1")
//    fun setUid(uid: String) {
//        this.uid = uid
//    }
//}
//}