package com.example.intermediate.ui.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.intermediate.data.repository.UserRepository

class LoginViewModel (
    private val userRepository: UserRepository
    ): ViewModel() {

    fun login (username: String, password: String) = userRepository.login(username,password)
//        fun login(){
//            Log.i(TAG, "viewmodel berhasil")
//        }
}