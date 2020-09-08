package com.example.loveactuallymeandroidapp.dataClass


class Chat2 {
    var userImage: String? = null
    private var Name: String? = null
    private var status: String? = null
    constructor() {

    }

    constructor(name: String?, status: String?, image: String) {
        this.Name = name
        this.status = status
        this.userImage = image
    }

    fun getName(): String? {
        return Name
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