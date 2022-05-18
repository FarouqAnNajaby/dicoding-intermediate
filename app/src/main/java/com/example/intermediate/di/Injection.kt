package com.dicoding.newsapp.di

import android.content.Context
import com.example.intermediate.api.ApiConfig
import com.example.intermediate.data.repository.UserRepository

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService)
    }
}