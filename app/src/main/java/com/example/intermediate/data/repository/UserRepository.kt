package com.example.intermediate.data.repository

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.intermediate.api.ApiConfig
import com.example.intermediate.data.model.ResponseDefault
import com.example.intermediate.data.model.ResponseLogin
import com.example.intermediate.ui.login.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (application: Application){

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(email: String, password: String) : LiveData<ResponseLogin> {
        val _loginResult = MutableLiveData<ResponseLogin>()
        val loginResult: LiveData<ResponseLogin> = _loginResult
        _isLoading.value = true
        val call = ApiConfig.getApiService().login(email, password)
        call.enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>){
                _isLoading.value = false
                if (response.isSuccessful) {
                    response.body()?.let {
                        _loginResult.value = response.body()
                    }
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })
        return loginResult
    }

    fun register(email: String, password: String, name: String) : LiveData<ResponseDefault>{
        val _registerResult = MutableLiveData<ResponseDefault>()
        val registerResult: LiveData<ResponseDefault> = _registerResult
        _isLoading.value = true
        val call = ApiConfig.getApiService().register(name,email, password)
        call.enqueue(object : Callback<ResponseDefault>{
            override fun onResponse(call: Call<ResponseDefault>,
                response: Response<ResponseDefault>) {
                if (response.isSuccessful) {
                    response.body()?.let {

                    }
                }
            }

            override fun onFailure(call: Call<ResponseDefault>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })
        return registerResult
    }
}