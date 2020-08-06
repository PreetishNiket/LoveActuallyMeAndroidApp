package com.example.loveactuallymeandroidapp.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignUpViewModel(application: Application):AndroidViewModel(application) {
    private val _string=MutableLiveData<String>().apply {
        value="Create Account"
    }
    val string:LiveData<String> =_string

}