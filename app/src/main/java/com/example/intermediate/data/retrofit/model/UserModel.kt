package com.example.intermediate.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class UserModel (

    @SerializedName("name")
    val name: String,

    @SerializedName("userId")
    val userId: String,

    @SerializedName("token")
    val token: String
)