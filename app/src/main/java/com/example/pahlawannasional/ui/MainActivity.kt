package com.example.pahlawannasional.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pahlawannasional.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvHomePahlawan.adapter = PahlawanAdapter(this@MainActivity)
            fabUp.setOnClickListener {
                rvHomePahlawan.scrollToPosition(0)
            }
        }
    }
}