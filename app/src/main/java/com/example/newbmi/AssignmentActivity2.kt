package com.example.newbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newbmi.databinding.ActivityAssignment2Binding

class AssignmentActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityAssignment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAssignment2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}