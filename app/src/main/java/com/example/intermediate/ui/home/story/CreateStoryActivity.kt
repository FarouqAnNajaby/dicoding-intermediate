package com.example.intermediate.ui.home.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intermediate.databinding.ActivityCreateStoryBinding
import com.example.intermediate.databinding.ActivityHomeBinding

class CreateStoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCreateStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}