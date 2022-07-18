package com.example.intermediate.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@SerializedName("loginResult")
	val loginResult: UserModel,

	@SerializedName("error")
	val error: Boolean,

	@SerializedName("message")
	val message: String
)
