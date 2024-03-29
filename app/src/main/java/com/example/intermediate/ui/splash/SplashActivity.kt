package com.example.intermediate.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intermediate.databinding.ActivityRegisterBinding
import com.example.intermediate.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}