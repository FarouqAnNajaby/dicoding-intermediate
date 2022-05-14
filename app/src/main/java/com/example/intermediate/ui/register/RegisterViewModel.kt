package com.example.intermediate.ui.register

import androidx.lifecycle.ViewModel
import com.example.intermediate.data.repository.UserRepository

class RegisterViewModel (private val userRepository: UserRepository): ViewModel() {
    fun register(username: String, password: String, name: String) = userRepository.register(username,password,name)
}