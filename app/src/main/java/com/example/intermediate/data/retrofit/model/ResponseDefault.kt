package com.example.intermediate.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class ResponseDefault (

    @SerializedName("error")
    val error: String,

    @SerializedName("message")
    val message: String

)