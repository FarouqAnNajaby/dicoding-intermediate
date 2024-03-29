package com.example.intermediate.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intermediate.databinding.ActivityHomeBinding
import com.example.intermediate.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}