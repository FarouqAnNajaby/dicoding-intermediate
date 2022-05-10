package com.example.intermediate.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intermediate.data.model.ResponseDefault
import com.example.intermediate.data.model.UserModel
import com.example.intermediate.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepository: UserRepository)
    : ViewModel() {

        fun registerUser(userModel: UserModel) : LiveData<ApiResponse<Response<ResponseDefault>>> {
            val result = MutableLiveData<ApiResponse<Response<ResponseDefault>>>()
            viewModelScope.launch {
                userRepository.registerUser(userModel).collect{
                    result.postValue(it)
                }
            }
            return result
        }
}