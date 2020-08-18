package com.example.loveactuallymeandroidapp.utils.dataClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Profiles1 (
    @SerializedName("name") @Expose var name: String,
    @SerializedName("url") @Expose var imageUrl: String,
    @SerializedName("age") @Expose var age: Int,
    @SerializedName("location") @Expose var location: String
)