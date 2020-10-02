package com.example.loveactuallymeandroidapp.dataClass


class Users {
    var userImage: String? = null
    private var Name: String? = null
    private var status: String? = null
    private var uid:String?=null
    private var MobileNumber: String? = null
    private var  About: String? = null
    private var Ability: String? = null
    private var type: String? = null
    private var religion:String? = null
    private var education:String? = null
    private var gender:String? = null
    private var dob:String? = null
    constructor() {

    }

    constructor(name: String?, status: String?, image: String,uid:String?) {
        this.Name = name
        this.status = status
        this.userImage = image
        this.uid=uid
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
    fun getMobileNumber():String?{
        return MobileNumber
    }
    fun getAbout():String?{
        return About
    }
    fun getAbility():String?{
        return Ability
    }
    fun gettype():String?{
        return type
    }
    fun getreligion():String?{
        return religion
    }
    fun geteducation():String?{
        return education
    }
    fun getgender():String?{
        return gender
    }
    fun getdob():String?{
        return dob
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