package com.example.intermediate.api

import com.example.intermediate.data.model.ResponseDefault
import com.example.intermediate.data.model.ResponseLogin
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("name") namename:String,
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<ResponseDefault>

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<ResponseLogin>
}