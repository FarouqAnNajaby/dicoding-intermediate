package com.example.intermediate.ui.home.story.detil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intermediate.databinding.ActivityCreateStoryBinding
import com.example.intermediate.databinding.ActivityDetilStoryBinding

class DetilStoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetilStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}