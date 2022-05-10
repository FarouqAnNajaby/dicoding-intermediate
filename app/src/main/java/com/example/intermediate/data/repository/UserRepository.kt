package com.example.intermediate.data.repository

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.intermediate.api.ApiConfig
import com.example.intermediate.data.model.ResponseLogin
import com.example.intermediate.data.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (application: Application){

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

//    private val loginResult : LiveData<ResponseLogin>()

//    fun login(email: String, password: String) : LiveData<ResponseLogin> {
//        _isLoading.value = true
//        val call = ApiConfig.getApiService().login(email, password)
//        call.enqueue(object : Callback<ResponseLogin> {
//            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>){
//                _isLoading.value = false
//                if (response.isSuccessful) {
//                    response.body()?.let {
//
//                    }
//                }else{
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                Log.d("Error", t.message.toString())
//            }
//        })
//        return a
//    }
}