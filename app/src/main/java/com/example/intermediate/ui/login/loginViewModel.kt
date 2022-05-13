package com.example.intermediate.ui.login

import androidx.lifecycle.ViewModel
import com.example.intermediate.data.repository.UserRepository

class loginViewModel(private val userRepository: UserRepository): ViewModel() {

    fun login (username: String, password: String) = userRepository.login(username,password)

}