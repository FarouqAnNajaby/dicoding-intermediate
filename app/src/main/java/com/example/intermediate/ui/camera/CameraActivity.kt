package com.example.intermediate.ui.camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intermediate.databinding.ActivityCameraBinding
import com.example.intermediate.databinding.ActivityHomeBinding

class CameraActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}